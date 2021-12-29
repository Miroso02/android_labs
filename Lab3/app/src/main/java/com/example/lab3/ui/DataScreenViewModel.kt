package com.example.lab3.ui

import androidx.lifecycle.ViewModel
import com.example.lab3.data.dao.QnADao

class DataScreenViewModel(private val qnADao: QnADao) : ViewModel() {
    fun getAllQnAs() = qnADao.getAll()
}