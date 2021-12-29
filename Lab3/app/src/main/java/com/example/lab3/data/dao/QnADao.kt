package com.example.lab3.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lab3.data.domain.QnA
import kotlinx.coroutines.flow.Flow

@Dao
interface QnADao {
    @Query("select * from qna")
    fun getAll(): Flow<List<QnA>>

    @Insert
    suspend fun saveQnA(qnA: QnA)
}
