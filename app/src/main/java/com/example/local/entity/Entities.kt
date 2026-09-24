package com.example.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarked_materials")
data class BookmarkedItemEntity(
    @PrimaryKey val materialId: String,
    val title: String,
    val subjectName: String,
    val examLevel: String,
    val examBoard: String,
    val materialType: String,
    val yearSession: String,
    val savedAtTimestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "quiz_results")
data class QuizResultEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val subjectName: String,
    val examLevel: String,
    val topic: String,
    val score: Int,
    val totalQuestions: Int,
    val percentage: Int,
    val completedAtTimestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "study_tasks")
data class StudyTaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val subjectName: String,
    val targetDate: String,
    val isCompleted: Boolean = false,
    val priority: String = "Normal" // "High", "Normal", "Low"
)
