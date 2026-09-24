package com.example.model

data class QuizQuestion(
    val id: String,
    val subjectId: String,
    val subjectName: String,
    val examLevel: ExamLevel,
    val topic: String,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class TimetableEntry(
    val id: String,
    val examBoard: ExamBoard,
    val level: ExamLevel,
    val subjectCode: String,
    val subjectName: String,
    val paperName: String,
    val dateDisplay: String, // e.g. "Mon, 20 Oct 2025"
    val sessionTime: String, // e.g. "09:00 AM - 11:30 AM"
    val sessionType: String, // "Morning" or "Afternoon"
    val durationText: String // "2 hrs 30 mins"
)
