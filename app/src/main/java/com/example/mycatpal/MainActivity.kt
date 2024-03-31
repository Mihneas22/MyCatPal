package com.example.mycatpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycatpal.features.presentation.screens.Auth.LoginInScreen
import com.example.mycatpal.features.presentation.screens.Auth.SignUpScreen
import com.example.mycatpal.features.presentation.screens.MainScreen
import com.example.mycatpal.ui.theme.MyCatPalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCatPalTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "SignUpScreen") {
                    composable("SignUpScreen"){
                        SignUpScreen(navController = navController)
                    }

                    composable("LoginInScreen"){
                        LoginInScreen(navController = navController)
                    }

                    composable("MainScreen"){
                        MainScreen()
                    }
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCatPalTheme {

    }
}