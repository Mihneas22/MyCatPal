package com.example.mycatpal.features.presentation.screens.MyCats

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.navigation.NavController
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.presentation.components.BottomBar
import com.example.mycatpal.ui.theme.darkPurple
import com.example.mycatpal.ui.theme.lighterRed

@Composable
fun CatScreen(
    cat: Cat,
    navController: NavController
){
    Column {
        HeaderCat(cat = cat)
        MainCatData(cat = cat,navController = navController)
        BottomBar(navController = navController)
    }
}
@Composable
fun HeaderCat(
    cat: Cat
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = darkPurple
        )
    ){
        Icon(imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Back",
            modifier = Modifier
                .padding(start = 5.dp, top = 5.dp)
                .height(50.dp)
                .width(50.dp)
        )
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Icon(imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )

            Text(text = cat.name,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 40.sp,
                color = lighterRed
            )
        }
    }
}
@Composable
fun MainCatData(
    cat: Cat,
    navController: NavController
){
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = darkPurple
        )
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 30.dp)
        ) {
            //Cat Name
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {

                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Name: ",
                    style = MaterialTheme.typography.bodyLarge,
                    color = lighterRed,
                    fontSize = 35.sp
                )

                Text(text = cat.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 30.sp
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .height(45.dp)
                            .width(45.dp)
                        )
                }
            }

            //Cat Gender
            Row(modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .clickable {

                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Gender: ",
                    style = MaterialTheme.typography.bodyLarge,
                    color = lighterRed,
                    fontSize = 35.sp
                )

                Text(text = cat.gender,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 30.sp
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .height(45.dp)
                            .width(45.dp)
                    )
                }
            }

            //Cat Breed
            Row(modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .clickable {

                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Breed: ",
                    style = MaterialTheme.typography.bodyLarge,
                    color = lighterRed,
                    fontSize = 35.sp
                )

                Text(text = cat.breed,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 30.sp
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .height(45.dp)
                            .width(45.dp)
                    )
                }
            }

            //Cat Age
            Row(modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .clickable {

                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Age: ",
                    style = MaterialTheme.typography.bodyLarge,
                    color = lighterRed,
                    fontSize = 35.sp
                )

                Text(text = cat.age,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 30.sp
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .height(45.dp)
                            .width(45.dp)
                    )
                }
            }

            //Cat Birthday
            Row(modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .clickable {

                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Birthday: ",
                    style = MaterialTheme.typography.bodyLarge,
                    color = lighterRed,
                    fontSize = 35.sp
                )

                Text(text = cat.birthday,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 30.sp
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .height(45.dp)
                            .width(45.dp)
                    )
                }
            }
        }
    }
}