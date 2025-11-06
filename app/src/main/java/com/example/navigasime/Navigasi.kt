package com.example.navigasime

import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    Formulir,
    Detail
}

@composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
){
    Scaffold { isiRuang
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir
    }

}