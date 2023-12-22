package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {
    Column {
        Button(onClick = { navController.navigate(ProfileScreen.route) }) {
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "user profile button image", alignment = Alignment.TopEnd, modifier = Modifier
                .height(100.dp)
                .width(100.dp))
        }

        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo", alignment = Alignment.Center)
    }
}