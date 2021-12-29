package com.example.lab3

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.lab3.data.AppDatabase
import com.example.lab3.ui.DataScreenViewModel
import com.example.lab3.ui.InputScreenViewModel
import com.example.lab3.ui.navigation.NavController
import com.example.lab3.ui.theme.Lab3Theme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    private lateinit var db: AppDatabase
    private lateinit var dataScreenViewModel: DataScreenViewModel
    private lateinit var inputScreenViewModel: InputScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").build()
        dataScreenViewModel = DataScreenViewModel(db.qnaDao())
        inputScreenViewModel = InputScreenViewModel(db.qnaDao())

        setContent {
            Lab3Theme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colors.background) {
                    NavController(
                        navController = navController,
                        dataScreenViewModel = dataScreenViewModel,
                        inputScreenViewModel = inputScreenViewModel
                    )
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun a() {
        val a = mapOf(1 to "", 2 to "", 3 to "")
        a.forEach { (num, str) ->
            b(num, str)
        }
    }

    fun b(num: Int, str: String) {
        println(num)
    }
}
