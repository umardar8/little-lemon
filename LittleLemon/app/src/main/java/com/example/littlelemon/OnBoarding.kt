package com.example.littlelemon

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoarding(navController: NavHostController, sharedPreferences: SharedPreferences) {
    var firstName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var lastName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val context = LocalContext.current
    val modifierStyle = Modifier.padding(10.dp).fillMaxWidth()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo", contentScale = ContentScale.Fit, modifier = Modifier.fillMaxWidth().padding(10.dp).size(30.dp))
        Text(text = "Lets get to know You!", modifier = Modifier.background(Color.DarkGray).padding(vertical = 30.dp).fillMaxWidth(), color = Color.White, textAlign = TextAlign.Center, fontSize = 18.sp)
        TextField(value = firstName, onValueChange = {firstName=it}, label = { Text(text = "First name") }, modifier = Modifier.fillMaxWidth().padding(top = 20.dp, bottom = 10.dp))
        TextField(value = lastName, onValueChange = {lastName=it}, label = {Text(text = "Last name")}, modifier = modifierStyle)
        TextField(value = email, onValueChange = {email=it}, label= {Text(text = "Email")}, modifier = modifierStyle)
        TextField(value = password, onValueChange = {password=it}, label= {Text(text = "Password")}, modifier = modifierStyle)
        Button(
            onClick = { if (firstName.toString().isBlank()) { Toast.makeText(context, "First is Blank", Toast.LENGTH_SHORT).show() }
                else if (lastName.toString().isBlank()) { Toast.makeText(context, "Last Name is Blank", Toast.LENGTH_SHORT).show() }
                else if (email.toString().isBlank()) { Toast.makeText(context, "Email is Blank", Toast.LENGTH_SHORT).show() }
                else if (password.toString().isBlank()) { Toast.makeText(context, "Password is Blank", Toast.LENGTH_SHORT).show() }
                else {
                    Toast.makeText(context, "Registration Successful!", Toast.LENGTH_SHORT).show()
                sharedPreferences.edit().putString("First Name", firstName.toString()).commit()
                sharedPreferences.edit().putString("Last Name", lastName.toString()).commit()
                sharedPreferences.edit().putString("Email", email.toString()).commit()
                sharedPreferences.edit().putString("Password", password.toString()).commit()
                sharedPreferences.edit().putBoolean("loginStatus", true).commit()
                    navController.navigate(HomeScreen.route)
                }
                      },
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            modifier = Modifier.fillMaxWidth().padding(top = 40.dp, bottom = 10.dp)
        ) {
            Text(text = "Register", color = Color.Black)
        }
    }
}