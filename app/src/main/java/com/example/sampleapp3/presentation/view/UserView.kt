package com.example.sampleapp3.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.sampleapp3.presentation.viewmodel.UserViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserView() {
    val viewModel: UserViewModel = koinViewModel()
    UserView(
        title = viewModel.title.collectAsState(),
        subTitle = viewModel.subTitle.collectAsState(),
        isLoading = viewModel.isLoading.collectAsState(),
        onClick = viewModel::onClickNextButton,
    )
}

@Composable
private fun UserView(
    title: State<String>,
    subTitle: State<String>,
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
                text = stringResource(R.string.user_screen_title),
                style = AppTypography.titleLarge
            )

            Text(
                modifier = Modifier
                    .padding(bottom = Dimensions.verticalInterval),
                text = title.value,
                style = AppTypography.titleLarge
            )

            Text(
                modifier = Modifier
                    .padding(bottom = Dimensions.verticalInterval),
                text = subTitle.value,
                style = AppTypography.bodyLarge
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = onClick,
            ) {
                Text(
                    text = "To Universities",
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
private fun UserViewPreview() {
    SampleApp3Theme {
        UserView(
            title = mutableStateOf("Title"),
            subTitle = mutableStateOf("Sub Title"),
            isLoading = mutableStateOf(true),
            onClick = {},
        )
    }
}
