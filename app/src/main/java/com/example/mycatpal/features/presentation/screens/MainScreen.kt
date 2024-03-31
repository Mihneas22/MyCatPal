package com.example.mycatpal.features.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mycatpal.features.presentation.components.BottomBar
import com.example.mycatpal.features.presentation.viewmodels.AuthViewModel
import com.example.mycatpal.features.presentation.viewmodels.UserManipulationViewModel
import com.example.mycatpal.ui.theme.darkPurple
import com.example.mycatpal.ui.theme.lighterPurple
import com.example.mycatpal.ui.theme.mySkinColor

@Composable
fun MainScreen(
    navController: NavController,
    email: String,
    userViewModel: UserManipulationViewModel = hiltViewModel()
){
    Column {
        Header()
        MainMainScreen()
        BottomBar(navController = navController)
    }
}
@Composable
fun Header() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = lighterPurple
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Icon(imageVector = Icons.Default.Analytics,
                contentDescription = "Profile",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp)
                    .clickable {

                    }
            )

            Text(
                text = "Home",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 40.sp,
                color = mySkinColor
            )

            Icon(imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp)
                    .clickable {

                    }
            )
        }
    }
}

@Composable
fun MainMainScreen(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(710.dp)
        .verticalScroll(rememberScrollState()),
        colors = CardDefaults.cardColors(
            containerColor = darkPurple
        ),
        shape = RectangleShape
    ){

    }
}