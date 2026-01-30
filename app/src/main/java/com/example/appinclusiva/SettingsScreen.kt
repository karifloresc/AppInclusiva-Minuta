package com.example.appinclusiva

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val darkMode by darkModeFlow(context).collectAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Ajustes", style = MaterialTheme.typography.headlineSmall)

        Card {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Modo nocturno", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "Activa tema oscuro para mejor visibilidad",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Switch(
                    checked = darkMode,
                    onCheckedChange = { enabled ->
                        scope.launch { setDarkMode(context, enabled) }
                    }
                )
            }
        }
    }
}
