package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.local.SytbayDatabase
import com.example.local.entity.BookmarkedItemEntity
import com.example.local.entity.QuizResultEntity
import com.example.local.entity.StudyTaskEntity
import com.example.model.ExamBoard
import com.example.model.ExamLevel
import com.example.model.MaterialType
import com.example.model.QuizQuestion
import com.example.model.StudyMaterial
import com.example.model.Subject
import com.example.model.TimetableEntry
import com.example.repository.SytbayRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class ScreenTab {
    HOME,
    LIBRARY,
    QUIZ,
    TIMETABLE,
    ABOUT
}

data class QuizSessionState(
    val isActive: Boolean = false,
    val subjectTitle: String = "",
    val questions: List<QuizQuestion> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val isAnswerSubmitted: Boolean = false,
    val userAnswers: Map<Int, Int> = emptyMap(), // questionIndex -> selectedOptionIndex
    val score: Int = 0,
    val isFinished: Boolean = false
)

class SytbayViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: SytbayRepository

    init {
        val dao = SytbayDatabase.getInstance(application).sytbayDao()
        repository = SytbayRepository(dao)
    }

    // Active Tab Navigation
    private val _currentTab = MutableStateFlow(ScreenTab.HOME)
    val currentTab: StateFlow<ScreenTab> = _currentTab.asStateFlow()

    fun selectTab(tab: ScreenTab) {
        _currentTab.value = tab
    }

    // Selected Material for Full Reader View
    private val _selectedMaterial = MutableStateFlow<StudyMaterial?>(null)
    val selectedMaterial: StateFlow<StudyMaterial?> = _selectedMaterial.asStateFlow()

    fun openMaterial(material: StudyMaterial) {
        _selectedMaterial.value = material
    }

    fun closeMaterial() {
        _selectedMaterial.value = null
    }

    // Selected Subject for Subject Details
    private val _selectedSubject = MutableStateFlow<Subject?>(null)
    val selectedSubject: StateFlow<Subject?> = _selectedSubject.asStateFlow()

    fun openSubject(subject: Subject) {
        _selectedSubject.value = subject
    }

    fun closeSubject() {
        _selectedSubject.value = null
    }

    // Search and Filter State
    val searchQuery = MutableStateFlow("")
    val selectedLevel = MutableStateFlow(ExamLevel.ALL)
    val selectedBoard = MutableStateFlow(ExamBoard.ALL)
    val selectedType = MutableStateFlow(MaterialType.ALL)

    // Subjects List
    val subjects: List<Subject> = repository.getSubjects()

    // Filtered Materials Flow
    val filteredMaterials: StateFlow<List<StudyMaterial>> = combine(
        searchQuery,
        selectedLevel,
        selectedBoard,
        selectedType
    ) { query, level, board, type ->
        repository.filterMaterials(query, level, board, type)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = repository.getStudyMaterials()
    )

    // Room Bookmarks Flow
    val bookmarkedEntities: StateFlow<List<BookmarkedItemEntity>> = repository.bookmarks
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun toggleBookmark(material: StudyMaterial) {
        viewModelScope.launch {
            val isCurrentlyBookmarked = bookmarkedEntities.value.any { it.materialId == material.id }
            repository.toggleBookmark(material, isCurrentlyBookmarked)
        }
    }

    // Room Quiz Results Flow
    val quizResults: StateFlow<List<QuizResultEntity>> = repository.quizResults
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // Room Study Tasks Flow
    val studyTasks: StateFlow<List<StudyTaskEntity>> = repository.studyTasks
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addStudyTask(title: String, subjectName: String, targetDate: String, priority: String) {
        viewModelScope.launch {
            repository.addStudyTask(title, subjectName, targetDate, priority)
        }
    }

    fun toggleTaskComplete(task: StudyTaskEntity) {
        viewModelScope.launch {
            repository.toggleTaskComplete(task)
        }
    }

    fun deleteTask(taskId: Long) {
        viewModelScope.launch {
            repository.deleteTask(taskId)
        }
    }

    // Timetable
    val timetableFilterBoard = MutableStateFlow(ExamBoard.ALL)
    val timetableList: StateFlow<List<TimetableEntry>> = timetableFilterBoard.combine(selectedLevel) { board, level ->
        repository.getTimetable(board, level)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = repository.getTimetable()
    )

    // Active Quiz Session
    private val _quizState = MutableStateFlow(QuizSessionState())
    val quizState: StateFlow<QuizSessionState> = _quizState.asStateFlow()

    fun startQuiz(subjectId: String? = null, customTitle: String? = null) {
        val questions = repository.getQuizQuestions(subjectId).shuffled()
        val title = customTitle ?: if (subjectId != null) {
            subjects.find { it.id == subjectId }?.name ?: "Subject Quiz"
        } else {
            "Sytbay Speed Revision Challenge"
        }

        _quizState.value = QuizSessionState(
            isActive = true,
            subjectTitle = title,
            questions = questions,
            currentIndex = 0,
            selectedOptionIndex = null,
            isAnswerSubmitted = false,
            userAnswers = emptyMap(),
            score = 0,
            isFinished = false
        )
    }

    fun selectQuizOption(optionIndex: Int) {
        if (_quizState.value.isAnswerSubmitted) return
        _quizState.value = _quizState.value.copy(selectedOptionIndex = optionIndex)
    }

    fun submitCurrentAnswer() {
        val state = _quizState.value
        val selected = state.selectedOptionIndex ?: return
        val currentQuestion = state.questions.getOrNull(state.currentIndex) ?: return

        val isCorrect = selected == currentQuestion.correctIndex
        val newScore = if (isCorrect) state.score + 1 else state.score
        val newAnswers = state.userAnswers.toMutableMap().apply {
            put(state.currentIndex, selected)
        }

        _quizState.value = state.copy(
            isAnswerSubmitted = true,
            score = newScore,
            userAnswers = newAnswers
        )
    }

    fun nextQuizQuestion() {
        val state = _quizState.value
        val nextIndex = state.currentIndex + 1

        if (nextIndex >= state.questions.size) {
            // Finished
            _quizState.value = state.copy(isFinished = true)
            // Save result to Room
            viewModelScope.launch {
                val firstQ = state.questions.firstOrNull()
                repository.saveQuizResult(
                    subjectName = state.subjectTitle,
                    examLevel = firstQ?.examLevel?.displayName ?: "General",
                    topic = firstQ?.topic ?: "Mixed Revision",
                    score = state.score,
                    total = state.questions.size
                )
            }
        } else {
            _quizState.value = state.copy(
                currentIndex = nextIndex,
                selectedOptionIndex = null,
                isAnswerSubmitted = false
            )
        }
    }

    fun exitQuiz() {
        _quizState.value = QuizSessionState(isActive = false)
    }
}
