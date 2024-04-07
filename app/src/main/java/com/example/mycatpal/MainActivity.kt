package com.example.mycatpal

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.presentation.screens.Auth.LoginInScreen
import com.example.mycatpal.features.presentation.screens.Auth.SignUpScreen
import com.example.mycatpal.features.presentation.screens.MainScreen
import com.example.mycatpal.features.presentation.screens.MyCats.AddCatScreen
import com.example.mycatpal.features.presentation.screens.MyCats.CatScreen
import com.example.mycatpal.features.presentation.screens.MyCats.MyCatsScreen
import com.example.mycatpal.features.presentation.viewmodels.UserViewModel
import com.example.mycatpal.ui.theme.MyCatPalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCatPalTheme {
                val navController = rememberNavController()
                var startDest by remember{
                    mutableStateOf("")
                }

                val loginData = mainViewModel.getAuthStateLogin().collectAsState().value
                val userData = mainViewModel.getAuthStateData().collectAsState().value

                if(loginData)
                {
                    startDest = "LoginInScreen"
                }
                else
                {
                    startDest = "MainScreen"
                }

                val email = userData?.email.toString()
                Log.d("emailD","data")

                NavHost(navController = navController, startDestination = startDest) {
                    composable("SignUpScreen"){
                        SignUpScreen(navController = navController)
                    }

                    composable("LoginInScreen"){
                        LoginInScreen(navController = navController)
                    }

                    composable("MainScreen") {
                        MainScreen(email = email, navController = navController)
                    }
                    
                    composable("MyCatsScreen"){
                        MyCatsScreen(email, navController)
                    }

                    composable("AddCatScreen"){
                        AddCatScreen(email=email,navController = navController)
                    }

                    composable("CatScreen/{cat}}"){backStackEntry ->
                        val cat: Cat = backStackEntry.arguments?.get("cat") as Cat
                        CatScreen(cat = cat, navController = navController)
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