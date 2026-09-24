package com.example.repository

import com.example.data.SytbayDataProvider
import com.example.local.dao.SytbayDao
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
import kotlinx.coroutines.flow.Flow

class SytbayRepository(private val dao: SytbayDao) {

    // In-memory study resources
    fun getSubjects(): List<Subject> = SytbayDataProvider.subjects

    fun getSubjectById(subjectId: String): Subject? =
        SytbayDataProvider.subjects.find { it.id == subjectId }

    fun getStudyMaterials(): List<StudyMaterial> = SytbayDataProvider.studyMaterials

    fun getMaterialById(materialId: String): StudyMaterial? =
        SytbayDataProvider.studyMaterials.find { it.id == materialId }

    fun filterMaterials(
        query: String = "",
        level: ExamLevel = ExamLevel.ALL,
        board: ExamBoard = ExamBoard.ALL,
        type: MaterialType = MaterialType.ALL
    ): List<StudyMaterial> {
        return SytbayDataProvider.studyMaterials.filter { material ->
            val matchesQuery = query.isBlank() ||
                material.title.contains(query, ignoreCase = true) ||
                material.subjectName.contains(query, ignoreCase = true) ||
                material.summary.contains(query, ignoreCase = true) ||
                material.keyTopics.any { it.contains(query, ignoreCase = true) }

            val matchesLevel = (level == ExamLevel.ALL) || (material.examLevel == level)
            val matchesBoard = (board == ExamBoard.ALL) || (material.examBoard == board)
            val matchesType = (type == MaterialType.ALL) || (material.type == type)

            matchesQuery && matchesLevel && matchesBoard && matchesType
        }
    }

    fun getQuizQuestions(subjectId: String? = null): List<QuizQuestion> {
        return if (subjectId == null) {
            SytbayDataProvider.quizQuestions
        } else {
            SytbayDataProvider.quizQuestions.filter { it.subjectId == subjectId }
        }
    }

    fun getTimetable(board: ExamBoard = ExamBoard.ALL, level: ExamLevel = ExamLevel.ALL): List<TimetableEntry> {
        return SytbayDataProvider.examinationTimetable.filter {
            (board == ExamBoard.ALL || it.examBoard == board) &&
            (level == ExamLevel.ALL || it.level == level)
        }
    }

    // Room Database Operations (Bookmarks)
    val bookmarks: Flow<List<BookmarkedItemEntity>> = dao.getAllBookmarks()

    fun isBookmarked(materialId: String): Flow<Boolean> = dao.isMaterialBookmarked(materialId)

    suspend fun toggleBookmark(material: StudyMaterial, currentlyBookmarked: Boolean) {
        if (currentlyBookmarked) {
            dao.deleteBookmarkById(material.id)
        } else {
            dao.insertBookmark(
                BookmarkedItemEntity(
                    materialId = material.id,
                    title = material.title,
                    subjectName = material.subjectName,
                    examLevel = material.examLevel.displayName,
                    examBoard = material.examBoard.displayName,
                    materialType = material.type.displayName,
                    yearSession = material.yearSession
                )
            )
        }
    }

    // Room Database Operations (Quiz Results)
    val quizResults: Flow<List<QuizResultEntity>> = dao.getAllQuizResults()

    suspend fun saveQuizResult(
        subjectName: String,
        examLevel: String,
        topic: String,
        score: Int,
        total: Int
    ) {
        val percentage = if (total > 0) (score * 100) / total else 0
        dao.insertQuizResult(
            QuizResultEntity(
                subjectName = subjectName,
                examLevel = examLevel,
                topic = topic,
                score = score,
                totalQuestions = total,
                percentage = percentage
            )
        )
    }

    // Room Database Operations (Study Tasks)
    val studyTasks: Flow<List<StudyTaskEntity>> = dao.getAllStudyTasks()

    suspend fun addStudyTask(title: String, subjectName: String, targetDate: String, priority: String) {
        dao.insertStudyTask(
            StudyTaskEntity(
                title = title,
                subjectName = subjectName,
                targetDate = targetDate,
                priority = priority
            )
        )
    }

    suspend fun toggleTaskComplete(task: StudyTaskEntity) {
        dao.updateStudyTask(task.copy(isCompleted = !task.isCompleted))
    }

    suspend fun deleteTask(taskId: Long) {
        dao.deleteStudyTaskById(taskId)
    }
}
