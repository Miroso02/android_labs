package com.example.lab3.data.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class QnA(
    val question: String,
    val answer: String,
    val date: Date = Calendar.getInstance().time,
    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
)