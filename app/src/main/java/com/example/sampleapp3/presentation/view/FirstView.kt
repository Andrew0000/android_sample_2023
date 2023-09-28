package com.example.sampleapp3.presentation.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleapp3.presentation.view.theme.SampleApp3Theme

@Composable
fun FirstView(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun FirstViewPreview() {
    SampleApp3Theme {
        FirstView("Android")
    }
}
