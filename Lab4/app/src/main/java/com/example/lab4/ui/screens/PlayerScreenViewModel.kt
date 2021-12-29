package com.example.lab4.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var playerPosition: Long
        get() = savedStateHandle["player position"] ?: 0
        set(value) {
            savedStateHandle["player position"] = value
        }
}