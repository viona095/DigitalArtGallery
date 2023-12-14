package com.example.digitalartgallery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.digitalartgallery.ui.theme.screens.home.HomeScreen
import com.example.digitalartgallery.ui.theme.screens.login.LoginScreen
import com.example.digitalartgallery.ui.theme.screens.products.AddproductsScreen
import com.example.digitalartgallery.ui.theme.screens.products.ViewProductsScreen
import com.example.digitalartgallery.ui.theme.screens.signup.SignupScreen


@Composable
fun AppNavHost(
    modifier: Modifier= Modifier,
    navController: NavHostController= rememberNavController(),
    startDestination: String = LOGIN_URL

){
    NavHost(
        navController =navController ,
        startDestination =startDestination ,
        modifier = modifier) {
        composable(LOGIN_URL) {
            LoginScreen(navController = navController)
        }
        composable(HOME_URL) {
            HomeScreen(navController = navController)
        }
        composable(ADD_PRODUCT_URL) {
            AddproductsScreen(navController = navController)
        }
        composable(SIGNUP_URL) {
            SignupScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL) {
            ViewProductsScreen(navController = navController)
        }
    }
}
