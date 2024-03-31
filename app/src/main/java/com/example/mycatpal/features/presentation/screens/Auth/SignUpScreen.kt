package com.example.mycatpal.features.presentation.screens.Auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mycatpal.features.domain.components.Resource
import com.example.mycatpal.features.presentation.components.CatButton
import com.example.mycatpal.features.presentation.components.CatTextField
import com.example.mycatpal.features.presentation.viewmodels.AuthViewModel
import com.example.mycatpal.ui.theme.darkPurple
import com.example.mycatpal.ui.theme.lighterPurple
import com.example.mycatpal.ui.theme.lighterRed
import com.example.mycatpal.ui.theme.myYellow

@Composable
fun SignUpScreen(
    navController: NavController,
    signUpViewModel: AuthViewModel = hiltViewModel()
) {
    var email by remember{
        mutableStateOf("")
    }

    var name by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }


    val context = LocalContext.current

    Card(modifier = Modifier
        .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = darkPurple
        ),
        shape = RectangleShape
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            Icon(imageVector = Icons.Default.Android,
                contentDescription = "My App Icon",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .padding(end = 10.dp)
            )
            Text(text = "My CatPal",
                style = MaterialTheme.typography.bodyLarge,
                color = myYellow,
                fontSize = 20.sp
            )
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(text = "Create Account",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 35.sp,
                    color = lighterRed
                )
            }

            //Username Part
            Column(modifier = Modifier.padding(top = 50.dp)){
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    text = "Name",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 24.sp,
                    color = lighterRed
                )

                CatTextField(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                        .fillMaxWidth(),
                    text = name,
                    onTextChange = {
                        if(it.all {char->
                            char.isDefined()
                        })name = it
                    }, label = "",
                    color = lighterPurple,
                    textColor = lighterRed)
            }

            //Email Part
            Column(modifier = Modifier.padding(top = 50.dp)) {
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    text = "Email",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 24.sp,
                    color = lighterRed
                )

                CatTextField(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                        .fillMaxWidth(),
                    text = email,
                    onTextChange = {
                        if(it.all {char->
                                char.isDefined()
                            })email = it
                    }, label = "",
                    color = lighterPurple,
                    textColor = lighterRed
                )
            }

            //Password Part
            Column(modifier = Modifier.padding(top = 50.dp)){
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    text = "Password",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 24.sp,
                    color = lighterRed
                )

                CatTextField(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                        .fillMaxWidth(),
                    text = password,
                    onTextChange = {
                        if(it.all {char->
                                char.isDefined()
                            })password = it
                    }, label = "",
                    color = lighterPurple,
                    textColor = lighterRed)
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                CatButton(
                    modifier = Modifier
                        .width(300.dp)
                        .height(40.dp),
                    text = "Create Account",
                    onButClick = {
                        if(name.isEmpty())
                            Toast.makeText(context,"Enter username first",Toast.LENGTH_SHORT).show()
                        else if(email.isEmpty())
                            Toast.makeText(context,"Enter email first",Toast.LENGTH_SHORT).show()
                        else if(password.isEmpty())
                            Toast.makeText(context,"Enter password first",Toast.LENGTH_SHORT).show()
                        else if(password.length<8)
                            Toast.makeText(context,"Enter a password with more than 8 letters",Toast.LENGTH_SHORT).show()
                        else {
                            signUpViewModel.signUpUser(email, password)
                            signUpViewModel.createUser(name,email,password)
                            if(signUpViewModel.signUpResponse == Resource.Success(true) && signUpViewModel.createUserResponse == Resource.Success(true))
                            {
                                navController.navigate("LoginInScreen")
                            }
                        }

                    },
                    color = lighterRed,
                    textColor = myYellow)
            }
        }
    }
}