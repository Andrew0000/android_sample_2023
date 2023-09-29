package com.example.sampleapp3.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sampleapp3.presentation.navigation.AppScreen
import com.example.sampleapp3.presentation.navigation.NavigationMediator
import com.example.sampleapp3.presentation.view.theme.SampleApp3Theme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val navigationMediator: NavigationMediator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleApp3Theme {
                MainLayout()
            }
        }
    }

    @Composable
    private fun MainLayout() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            val navController = rememberNavController()
            AppNavigationHost(navController)
            NavigationUpdater(navController)
        }
    }

    @Composable
    private fun AppNavigationHost(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = AppScreen.USER.id,
        ) {
            composable(AppScreen.USER.id) { UserView() }
            composable(AppScreen.UNIVERSITIES.id) { UniversitiesView() }
        }
    }

    @Composable
    private fun NavigationUpdater(navController: NavHostController) {
        val requestedScreen = navigationMediator.requestedScreen.collectAsState()
        LaunchedEffect(requestedScreen.value) {
            navController.popBackStack()
            navController.navigate(requestedScreen.value.id)
        }
    }
}
