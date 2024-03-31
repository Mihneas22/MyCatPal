package com.example.mycatpal.features.presentation.screens.MyCats

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.presentation.components.CatButton
import com.example.mycatpal.features.presentation.components.CatTextField
import com.example.mycatpal.features.presentation.viewmodels.CatViewModel
import com.example.mycatpal.ui.theme.darkPurple
import com.example.mycatpal.ui.theme.lighterPurple
import com.example.mycatpal.ui.theme.lighterRed
import com.example.mycatpal.ui.theme.mySkinColor
import com.example.mycatpal.ui.theme.myYellow

@Composable
fun AddCatScreen(
    email: String,
    navController: NavController,
    catViewModel: CatViewModel = hiltViewModel()
){

    var name by remember{
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }

    var breed by remember {
        mutableStateOf("")
    }

    var birthday by remember {
        mutableStateOf("")
    }

    var choosedOption by remember {
        mutableIntStateOf(0)
    }

    var color1 = Color.White
    var color2 = Color.White

    Card(modifier = Modifier
        .fillMaxSize(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = darkPurple
        )
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(lighterPurple)
        ) {
            Row(modifier = Modifier
                .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Icon(imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Analytics",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(60.dp)
                        .clickable {
                            navController.navigate("MyCatsScreen")
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

        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(modifier = Modifier
                .height(600.dp)
                .width(350.dp)
                .padding(top = 50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = lighterPurple
                )
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Icon(imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = "Account",
                        modifier = Modifier
                            .height(70.dp)
                            .width(70.dp)
                    )

                    CatTextField(
                        modifier = Modifier.padding(top = 20.dp),
                        text = name,
                        onTextChange = {
                            if(it.all { char->
                                char.isLetter()
                            })name=it
                        },
                        label = "Enter nickname",
                        color = lighterRed,
                        textColor = myYellow)

                    CatTextField(
                        modifier = Modifier.padding(top = 20.dp),
                        text = breed,
                        onTextChange = {
                            if(it.all { char->
                                    char.isLetter()
                                })breed=it
                        },
                        label = "Enter breed",
                        color = lighterRed,
                        textColor = myYellow)

                    Row(modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Card(modifier = Modifier
                            .width(150.dp)
                            .height(30.dp)
                            .clickable {
                                choosedOption = 1
                                color1 = Color.Gray
                                color2 = Color.White
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = color1
                            )
                        ) {
                            Column(modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                Text(text = "Male")
                            }
                        }
                        Card(modifier = Modifier
                            .width(150.dp)
                            .height(30.dp)
                            .clickable {
                                choosedOption = 2
                                color2 = Color.Gray
                                color1 = Color.White
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = color2)
                        ) {
                            Column(modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                Text(text = "Female")
                            }
                        }
                    }

                    CatTextField(
                        modifier = Modifier.padding(top = 20.dp),
                        text = birthday,
                        onTextChange = {
                            if(it.all { char->
                                    char.isDefined()
                                })birthday=it
                        },
                        label = "Enter birthday",
                        color = lighterRed,
                        textColor = myYellow)

                    CatTextField(
                        modifier = Modifier.padding(top = 20.dp),
                        text = age,
                        onTextChange = {
                            if(it.all { char->
                                    char.isDigit()
                                })age=it
                        },
                        label = "Enter age",
                        color = lighterRed,
                        textColor = myYellow)
                }
            }

            CatButton(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(200.dp),
                text = "Save Cat",
                onButClick = {
                    val cat = Cat(
                        name = name,
                        age = age,
                        gender = choosedOption.toString(),
                        breed = breed,
                        birthday = birthday,
                        image = ""
                    )
                             catViewModel.addCat(email,cat)
                    navController.navigate("MyCatsScreen")
                },
                color = lighterRed,
                textColor = myYellow)
        }
    }
}