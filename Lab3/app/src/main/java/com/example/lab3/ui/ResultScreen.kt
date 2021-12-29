package com.example.lab3.ui

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab3.R
import kotlinx.coroutines.flow.collect

@Composable
fun ResultScreen(
    navController: NavController,
    viewModel: InputScreenViewModel
) {
    val context = LocalContext.current

    BackHandler { navController.popBackStack() }

    LaunchedEffect(Unit) {
        viewModel.saveQnA()
        viewModel.entrySaved.collect {
            context.toast(R.string.saved_message)
        }
    }

    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            text = stringResource(R.string.result_screen_title),
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
        Text(text = stringResource(R.string.question_text, viewModel.question))
        Text(text = stringResource(R.string.answer_text, viewModel.answer))
    }
}

fun Context.toast(resId: Int) {
    Toast.makeText(this, resources.getString(resId), Toast.LENGTH_SHORT).show()
}