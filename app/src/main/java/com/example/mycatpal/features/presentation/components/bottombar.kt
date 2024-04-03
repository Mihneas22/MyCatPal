package com.example.mycatpal.features.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Home
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
import com.example.mycatpal.features.presentation.viewmodels.AuthViewModel
import com.example.mycatpal.features.presentation.viewmodels.TrackedUserViewModel
import com.example.mycatpal.ui.theme.lighterPurple
import com.example.mycatpal.ui.theme.mySkinColor

@Composable
fun BottomBar(
    navController: NavController,
    authViewModel: AuthViewModel = hiltViewModel(),
    trackedUserViewModel: TrackedUserViewModel = hiltViewModel()
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = lighterPurple
        )
    ) {
        Row(modifier = Modifier
            .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            //Home Screen
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .clickable {
                        navController.navigate("MainScreen")
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.Home,
                    contentDescription = "HomeScreen",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )

                Text(text = "Home",
                    style = MaterialTheme.typography.bodyLarge,
                    color = mySkinColor,
                    fontSize = 18.sp
                )
            }


            //My Cats
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .clickable {
                        navController.navigate("MyCatsScreen")
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.Pets,
                    contentDescription = "HomeScreen",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )

                Text(text = "My Cats",
                    style = MaterialTheme.typography.bodyLarge,
                    color = mySkinColor,
                    fontSize = 18.sp
                )
            }


            //Cat Real
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .clickable { },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "HomeScreen",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )

                Text(text = "CatReal",
                    style = MaterialTheme.typography.bodyLarge,
                    color = mySkinColor,
                    fontSize = 18.sp
                )
            }

            //Log Out
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .clickable {
                        authViewModel.logOut()
                        trackedUserViewModel.deleteTrackedUser()
                        navController.navigate("LoginInScreen")
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "HomeScreen",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )

                Text(text = "Log Out",
                    style = MaterialTheme.typography.bodyLarge,
                    color = mySkinColor,
                    fontSize = 18.sp
                )
            }
        }
    }
}