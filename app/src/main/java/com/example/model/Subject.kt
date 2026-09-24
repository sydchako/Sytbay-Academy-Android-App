package com.example.model

data class Subject(
    val id: String,
    val name: String,
    val code: String,
    val level: ExamLevel,
    val examBoard: ExamBoard,
    val description: String,
    val papersCount: Int,
    val notesCount: Int,
    val quizzesCount: Int,
    val category: String // "Sciences", "Commercials", "Humanities", "Languages", "Technical"
)
