package com.example.lab3.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab3.R
import com.example.lab3.ui.navigation.Routes

@Composable
fun InputScreen(
    navController: NavController,
    viewModel: InputScreenViewModel
) {
    var question by remember { mutableStateOf(viewModel.question) }
    var answer by remember { mutableStateOf(viewModel.answer) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.app_name),
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors(
                backgroundColor = MaterialTheme.colors.background
            ),
            value = question,
            label = { Text(stringResource(R.string.input_request)) },
            onValueChange = {
                question = it
                viewModel.question = question
            },
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            RadioButtonWithText(
                modifier = Modifier.weight(0.5f),
                text = Answer.Yes.text,
                selected = answer == Answer.Yes,
                onClick = {
                    answer = Answer.Yes
                    viewModel.answer = answer
                }
            )
            RadioButtonWithText(
                modifier = Modifier.weight(0.5f),
                text = Answer.No.text,
                selected = answer == Answer.No,
                onClick = {
                    answer = Answer.No
                    viewModel.answer = answer
                }
            )
        }
        Button(
            modifier = Modifier.padding(top = 32.dp),
            onClick = {
                if (question.isNotBlank()) {
                    navController.navigate(Routes.Result)
                } else {
                    context.toast(R.string.blank_question_error)
                }
            }
        ) {
            Text(text = stringResource(R.string.ok_button))
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = {
                navController.navigate(Routes.Data)
            }
        ) {
            Text(text = stringResource(R.string.history_button))
        }
    }
}

@Composable
fun RadioButtonWithText(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable { onClick() }
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(text = text)
    }
}

enum class Answer(val text: String) {
    Yes("Yes"),
    No("No")
}