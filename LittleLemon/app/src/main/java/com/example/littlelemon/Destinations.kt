package com.example.littlelemon

interface Destinations {
    val route: String
}

object HomeScreen: Destinations {
    override val route: String = "Home"
}
object OnboardingScreen: Destinations {
    override val route: String = "Registration"
}
object ProfileScreen: Destinations {
    override val route: String = "Profile"
}
