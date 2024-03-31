package com.example.mycatpal.features.presentation.screens.MyCats

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.presentation.components.BottomBar
import com.example.mycatpal.features.presentation.components.CatButton
import com.example.mycatpal.features.presentation.viewmodels.CatViewModel
import com.example.mycatpal.ui.theme.darkPurple
import com.example.mycatpal.ui.theme.darkerRed
import com.example.mycatpal.ui.theme.lighterPurple
import com.example.mycatpal.ui.theme.mySkinColor
import com.example.mycatpal.ui.theme.myYellow

@Composable
fun MyCatsScreen(
    email: String,
    navController: NavController,
    catViewModel: CatViewModel = hiltViewModel()
){
    catViewModel.getAllCatData(email)
    val listCats = catViewModel.allCats.value
    Log.d("catLog","data: $listCats")
    Column {
        Header()
        MainCatsScreen(listCats = listCats,navController = navController)
        BottomBar(navController = navController)
    }
}

@Composable
fun Header(){
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
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Icon(imageVector = Icons.Default.Analytics,
                contentDescription = "Analytics",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp)
                    .clickable {

                    }
            )

            Text(text = "My Cats",
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
fun MainCatsScreen(
    listCats: List<Cat>,
    navController: NavController
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(710.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = darkPurple
        )
    ){
        Card(modifier = Modifier
            .height(600.dp),
            colors = CardDefaults.cardColors(
                containerColor = darkPurple
            )
        ) {
            LazyColumn{
                items(listCats){cat->
                    CatCard(cat = cat)
                }
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CatButton(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(end = 30.dp, bottom = 30.dp),
                text = "+",
                onButClick = {
                    navController.navigate("AddCatScreen");
                },
                color = Color.Blue,
                textColor = Color.White
            )
        }
    }
}

@Composable
fun CatCard(
    cat: Cat
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(top = 30.dp, start = 30.dp, end = 30.dp),
        colors = CardDefaults.cardColors(
            containerColor = myYellow
        )
    ) {
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Animal Photo",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Text(text = cat.name,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 35.sp,
                color = darkerRed
            )
        }
    }
}

