package com.example.sampleapp3.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sampleapp3.presentation.view.theme.AppTypography
import com.example.sampleapp3.presentation.view.theme.SampleApp3Theme
import com.example.sampleapp3.presentation.viewmodel.FirstViewModel
import com.example.sampleapp3.presentation.viewmodel.ViewModelFactory

@Composable
fun FirstView() {
    //TODO ViewModelFactory from DI
    val viewModel: FirstViewModel = viewModel(factory = ViewModelFactory())
    FirstView(
        title = viewModel.title.collectAsState(),
        subTitle = viewModel.subTitle.collectAsState(),
    )
}

@Composable
private fun FirstView(
    title: State<String>,
    subTitle: State<String>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = title.value,
            style = AppTypography.titleLarge
        )
        Text(
            text = subTitle.value,
            style = AppTypography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
@SuppressLint("UnrememberedMutableState")
private fun FirstViewPreview() {
    SampleApp3Theme {
        FirstView(
            title = mutableStateOf("Title"),
            subTitle = mutableStateOf("Sub Title"),
        )
    }
}
