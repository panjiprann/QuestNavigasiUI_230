package com.example.navigasime

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir,

            modifier = Modifier.padding(paddingValues= isiRuang)){
            composable(route = Navigasi.Formulir.name){
                FormIsian(
                    onSubmitButton = {
                    navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilanData(
                    onBackBtnClick = {cancelAndBackToFormulir(navController)}
                )
            }
        }
    }

}