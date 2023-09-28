package com.example.sampleapp3.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampleapp3.presentation.view.theme.AppTypography
import com.example.sampleapp3.presentation.view.theme.SampleApp3Theme
import com.example.sampleapp3.presentation.viewmodel.SecondScreenItem
import com.example.sampleapp3.presentation.viewmodel.SecondViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SecondView() {
    val viewModel: SecondViewModel = koinViewModel()
    SecondView(
        items = viewModel.items.collectAsState(),
        onClick = viewModel::onClickBack,
    )
}

@Composable
private fun SecondView(
    items: State<List<SecondScreenItem>>,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            reverseLayout = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            items(
                items = items.value,
                itemContent = { item ->
                    Text(
                        text = item.name,
                        style = AppTypography.titleLarge
                    )
                }
            )
        }
        Button(onClick = onClick) {
            Text(
                text = "To First",
                style = AppTypography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
@SuppressLint("UnrememberedMutableState")
private fun SecondViewPreview() {
    SampleApp3Theme {
        SecondView(
            items = mutableStateOf(
                listOf(
                    SecondScreenItem("First", "Description"),
                    SecondScreenItem("Second", "Description"),
                )
            ),
            onClick = {},
        )
    }
}
