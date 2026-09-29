package com.example.aplicaciontaller.navigation

import com.example.aplicaciontaller.View.CartView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplicaciontaller.View.FavoritesView
import com.example.aplicaciontaller.View.HomeView
import com.example.aplicaciontaller.View.LoginView
import com.example.aplicaciontaller.View.OffersView
import com.example.aplicaciontaller.View.ProfileView
import com.example.aplicaciontaller.View.RegisterView
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // Verificar si hay sesión activa
    val startRoute = if (FirebaseAuth.getInstance().currentUser != null) {
        Routes.Home.routes
    } else {
        Routes.Login.routes
    }

    NavHost(
        navController = navController,
        startDestination = startRoute,
        modifier = modifier
    ) {
        composable(Routes.Login.routes) {
            LoginView(
                onNavigateToRegister = { navController.navigate(Routes.Register.routes) },
                onLoginSuccess = {
                    navController.navigate(Routes.Home.routes) {
                        popUpTo(Routes.Login.routes) { inclusive = true }
                    }
                },
                modifier = modifier
            )
        }
        composable(Routes.Register.routes) {
            RegisterView(
                onNavigateToLogin = { navController.navigate(Routes.Login.routes) },
                onRegisterSuccess = {
                    navController.navigate(Routes.Home.routes) {
                        popUpTo(Routes.Register.routes) { inclusive = true }
                    }
                },
            )
        }

        composable(Routes.Home.routes) {
            HomeView(
                onItemSelected = { index ->
                    navigateByBar(navController, index)
                },
                onCartClick = {
                    navController.navigate(Routes.Cart.routes)
                }
            )
        }
        composable(Routes.Offers.routes) {
            OffersView(
                onItemSelected = { index ->
                    navigateByBar(navController, index)
                }
            )
        }
        composable(Routes.Favorites.routes) {
            FavoritesView(
                onItemSelected = { index ->
                    navigateByBar(navController, index)
                }
            )
        }
        composable(Routes.Profile.routes) {
            ProfileView(
                onItemSelected = { index ->
                    navigateByBar(navController, index)
                },
                onLogout = {
                    navController.navigate(Routes.Login.routes){
                        popUpTo(Routes.Home.routes){inclusive = true}
                    }
                }
            )
        }
        composable(Routes.Cart.routes) {
            CartView(
                onItemSelected = { index ->
                    navigateByBar(navController, index)
                },
                onBackClick = {navController.popBackStack()}
            )
        }
    }
}

fun navigateByBar(navController: NavHostController, index: Int) {
    when (index){
        0 -> navController.navigate(Routes.Home.routes)
        1 -> navController.navigate(Routes.Offers.routes)
        2 -> navController.navigate(Routes.Favorites.routes)
        3 -> navController.navigate(Routes.Profile.routes)
    }
}
