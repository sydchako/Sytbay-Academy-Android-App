package com.example.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.local.entity.BookmarkedItemEntity
import com.example.local.entity.QuizResultEntity
import com.example.local.entity.StudyTaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SytbayDao {

    // Bookmarked Materials
    @Query("SELECT * FROM bookmarked_materials ORDER BY savedAtTimestamp DESC")
    fun getAllBookmarks(): Flow<List<BookmarkedItemEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarked_materials WHERE materialId = :materialId)")
    fun isMaterialBookmarked(materialId: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkedItemEntity)

    @Query("DELETE FROM bookmarked_materials WHERE materialId = :materialId")
    suspend fun deleteBookmarkById(materialId: String)

    // Quiz Results
    @Query("SELECT * FROM quiz_results ORDER BY completedAtTimestamp DESC")
    fun getAllQuizResults(): Flow<List<QuizResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizResult(result: QuizResultEntity)

    // Study Tasks
    @Query("SELECT * FROM study_tasks ORDER BY isCompleted ASC, id DESC")
    fun getAllStudyTasks(): Flow<List<StudyTaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudyTask(task: StudyTaskEntity)

    @Update
    suspend fun updateStudyTask(task: StudyTaskEntity)

    @Query("DELETE FROM study_tasks WHERE id = :taskId")
    suspend fun deleteStudyTaskById(taskId: Long)
}
