package com.example.lab3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab3.data.dao.QnADao
import com.example.lab3.data.domain.QnA
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class InputScreenViewModel(private val qnADao: QnADao) : ViewModel() {
    private val _entrySaved = MutableSharedFlow<Unit>()
    val entrySaved: SharedFlow<Unit> = _entrySaved

    var question: String = ""
    var answer: Answer = Answer.No

    fun saveQnA() = viewModelScope.launch {
        qnADao.saveQnA(QnA(question, answer.text))
        _entrySaved.emit(Unit)
    }
}