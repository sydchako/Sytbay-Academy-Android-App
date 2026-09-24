package com.example.model

data class StudyMaterial(
    val id: String,
    val title: String,
    val subjectId: String,
    val subjectName: String,
    val examLevel: ExamLevel,
    val examBoard: ExamBoard,
    val type: MaterialType,
    val yearSession: String, // e.g. "Nov 2024", "June 2023", "2024 - 2026 Edition"
    val paperNumber: String, // e.g. "Paper 1 (Multiple Choice)", "Paper 2 (Theory)"
    val pages: Int,
    val sizeText: String, // e.g. "2.4 MB"
    val viewsCount: Int,
    val summary: String,
    val keyTopics: List<String>,
    val fullContent: String,
    val formulaSheet: String? = null,
    val sampleQuestionsWithSolutions: List<QuestionSolution> = emptyList()
)

data class QuestionSolution(
    val questionNumber: String,
    val questionText: String,
    val answerText: String,
    val examinerNotes: String? = null
)
