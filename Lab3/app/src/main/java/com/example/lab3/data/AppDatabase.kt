package com.example.lab3.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lab3.data.dao.QnADao
import com.example.lab3.data.domain.QnA

@Database(entities = [QnA::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun qnaDao(): QnADao
}