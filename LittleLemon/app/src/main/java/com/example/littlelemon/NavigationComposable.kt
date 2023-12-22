package com.example.littlelemon

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, sharedPreferences: SharedPreferences){
    var loginStatus = sharedPreferences.getBoolean("loginStatus", false)
    NavHost(
        navController = navController,
        startDestination = when(loginStatus) {
        true -> HomeScreen.route
        false -> OnboardingScreen.route
        }
    ) {
        composable(OnboardingScreen.route) {
            OnBoarding(navController, sharedPreferences)
        }
        composable(HomeScreen.route) {
            Home(navController)
        }
        composable(ProfileScreen.route) {
            Profile(navController, sharedPreferences)
        }
    }
}