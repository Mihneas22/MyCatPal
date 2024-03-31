package com.example.mycatpal.features.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mycatpal.features.presentation.viewmodels.UserManipulationViewModel

@Composable
fun MainScreen(
    email: String,
    userViewModel: UserManipulationViewModel = hiltViewModel()
){
    userViewModel.getUserData(email)
    Text(text = "Hello " + userViewModel.user.value.username,
        fontSize = 40.sp)
}