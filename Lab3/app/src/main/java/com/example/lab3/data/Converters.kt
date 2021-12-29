package com.example.lab3.data

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun longFromDate(date: Date) = date.time
    @TypeConverter
    fun dateFromLong(time: Long) = Date(time)
}