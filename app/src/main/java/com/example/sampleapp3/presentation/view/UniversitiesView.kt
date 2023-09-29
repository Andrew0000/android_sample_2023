package com.example.sampleapp3.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleapp3.R
import com.example.sampleapp3.presentation.view.theme.AppTypography
import com.example.sampleapp3.presentation.view.theme.Dimensions
import com.example.sampleapp3.presentation.view.theme.SampleApp3Theme
import com.example.sampleapp3.presentation.viewmodel.UniversityScreenItem
import com.example.sampleapp3.presentation.viewmodel.UniversitiesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UniversitiesView() {
    val viewModel: UniversitiesViewModel = koinViewModel()
    UniversitiesView(
        items = viewModel.items.collectAsState(),
        isLoading = viewModel.isLoading.collectAsState(),
        onClick = viewModel::onClickBack,
    )
}

@Composable
private fun UniversitiesView(
    items: State<List<UniversityScreenItem>>,
    isLoading: State<Boolean>,
    onClick: () -> Unit,
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimensions.screenPadding)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = Dimensions.screenPadding),
                text = stringResource(R.string.universities_screen_title),
                style = AppTypography.titleLarge
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = Dimensions.screenPadding)
            ) {
                items(
                    items = items.value,
                    itemContent = { item ->
                        Text(
                            modifier = Modifier
                                .padding(bottom = Dimensions.verticalInterval),
                            text = item.name,
                            style = AppTypography.bodyLarge
                        )
                    }
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = onClick,
            ) {
                Text(
                    text = "To User",
                    style = AppTypography.bodyLarge
                )
            }
        }

        if (isLoading.value) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
@SuppressLint("UnrememberedMutableState")
private fun UniversitiesPreview() {
    SampleApp3Theme {
        UniversitiesView(
            items = mutableStateOf(
                listOf(
                    UniversityScreenItem("First", "Description"),
                    UniversityScreenItem("Second", "Description"),
                )
            ),
            isLoading = mutableStateOf(true),
            onClick = {},
        )
    }
}
