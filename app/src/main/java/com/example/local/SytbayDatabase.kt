package com.example.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.local.dao.SytbayDao
import com.example.local.entity.BookmarkedItemEntity
import com.example.local.entity.QuizResultEntity
import com.example.local.entity.StudyTaskEntity

@Database(
    entities = [
        BookmarkedItemEntity::class,
        QuizResultEntity::class,
        StudyTaskEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SytbayDatabase : RoomDatabase() {

    abstract fun sytbayDao(): SytbayDao

    companion object {
        @Volatile
        private var INSTANCE: SytbayDatabase? = null

        fun getInstance(context: Context): SytbayDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SytbayDatabase::class.java,
                    "sytbay_academy.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
