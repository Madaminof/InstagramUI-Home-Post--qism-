package com.example.instagramprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.instagramprofile.ui.theme.InstagramProfileTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.instagramprofile.Navigation.AppNavHost
import androidx.navigation.compose.rememberNavController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstagramProfileTheme {
                val navController = rememberNavController()
                AppNavHost(
                    navController = navController,
                )
            }
        }
    }
}









