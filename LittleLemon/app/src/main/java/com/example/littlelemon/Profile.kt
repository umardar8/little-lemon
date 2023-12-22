package com.example.littlelemon

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Profile(navController: NavHostController, sharedPreferences: SharedPreferences) {
    var firstName = sharedPreferences.getString("First Name", "First Name")
    var lastName = sharedPreferences.getString("Last Name", "Last Name")
    var email = sharedPreferences.getString("Email", "Email")
    val context = LocalContext.current
    Column {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo")
        Text(text = "Profile Information:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = "First Name:", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = firstName.toString(), fontSize = 16.sp)
        Text(text = "Last Name:", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = lastName.toString(), fontSize = 16.sp)
        Text(text = "Email:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = email.toString(), fontSize = 16.sp)
        Button(onClick = {
            Toast.makeText(context, "Logged out!", Toast.LENGTH_SHORT).show()
            sharedPreferences.edit().putString("First Name", null).commit()
            sharedPreferences.edit().putString("Last Name", null).commit()
            sharedPreferences.edit().putString("Email", null).commit()
            sharedPreferences.edit().putBoolean("loginStatus", false).commit()
            navController.navigate(OnboardingScreen.route)
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), colors = ButtonDefaults.buttonColors(Color.Yellow)) {
            Text(text = "Log out")
        }
    }

}