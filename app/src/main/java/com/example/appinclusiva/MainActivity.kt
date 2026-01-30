package com.example.appinclusiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appinclusiva.ui.theme.AppInclusivaTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode by darkModeFlow(this).collectAsState(initial = false)

            AppInclusivaTheme(darkTheme = darkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("home") },
                onRegisterClick = { navController.navigate("register") },
                onRecoverClick = { navController.navigate("recover") }
            )
        }

        composable("home") {
            HomeScreen(
                onGoToGrid = { navController.navigate("grid") },
                onGoToTable = { navController.navigate("table") },
                onGoToMinuta = { navController.navigate("minuta") },
                onGoToSettings = { navController.navigate("settings") }
            )
        }

        composable("grid") { GridScreen() }
        composable("table") { TableScreen() }

        // ✅ NUEVO: Semana 4
        composable("minuta") {
            MinutaScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable("settings") { SettingsScreen() }

        composable("register") {
            RegisterScreen(onBackToLogin = { navController.popBackStack() })
        }
        composable("recover") {
            RecoverScreen(onBackToLogin = { navController.popBackStack() })
        }
    }
}
