package com.example.lab3.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab3.R
import java.text.SimpleDateFormat
import java.util.*

private val dateFormatter = SimpleDateFormat("dd.MM HH:mm", Locale.US)

@ExperimentalMaterialApi
@Composable
fun DataScreen(
    navController: NavController,
    viewModel: DataScreenViewModel
) {
    val displayData by viewModel.getAllQnAs().collectAsState(initial = listOf())
    val scrollState = rememberLazyListState()

    BackHandler { navController.popBackStack() }
    Column(modifier = Modifier.fillMaxHeight()) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.data_screen_title),
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
        if (displayData.isEmpty()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.no_data),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        } else {
            LazyColumn(modifier = Modifier.padding(horizontal = 16.dp), state = scrollState) {
                item {
                    Column {
                        ListItem(str1 = "Question", str2 = "Answer", str3 = "Date")
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.Black,
                            thickness = 1.dp
                        )
                    }
                }

                items(displayData) { (question, answer, date) ->
                    ListItem(str1 = question, str2 = answer, str3 = dateFormatter.format(date))
                }
            }
        }
    }
}

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    str1: String,
    str2: String,
    str3: String
) {
    Row(modifier = modifier) {
        Text(modifier = Modifier.weight(0.5f).padding(end = 4.dp), text = str1)
        Text(modifier = Modifier.weight(0.2f), text = str2)
        Text(modifier = Modifier.weight(0.3f), text = str3)
    }
}