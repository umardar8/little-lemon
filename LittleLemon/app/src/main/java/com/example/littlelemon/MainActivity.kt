package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val client = HttpClient(Android) {
        install(ContentNegotiation)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            val menu = MenuNetwork()
        }
        setContent {
            LittleLemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Navigation(navController, sharedPreferences)
                }
            }
        }
    }
    private suspend fun getMenu(): List<Map<String, String>> {
        val response: Map<String, List<Map<String, String>>> = client
            .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body()
        return response["menu"] ?: listOf()
    }

}