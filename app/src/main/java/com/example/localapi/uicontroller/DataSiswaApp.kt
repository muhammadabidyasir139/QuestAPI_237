package com.example.localapi.uicontroller

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.localapi.ui.view.siswa.EntrySiswaScreen

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.localapi.uicontroller.route.DestinasiEntry
import com.example.localapi.ui.view.siswa.EntrySiswaScreen
import com.example.localapi.ui.view.siswa.HomeScreen
import com.example.localapi.uicontroller.route.DestinasiHome
import com.example.localapi.uicontroller.route.DestinasiDetail
import com.example.localapi.ui.view.siswa.DetailSiswaScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { itemId ->
                    navController.navigate("${DestinasiDetail.route}/$itemId")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.idSiswa) {
                type = NavType.StringType
            })
        ) {
            DetailSiswaScreen(
                navigateBack = { navController.popBackStack() },
                navigateToEdit = { /* navController.navigate("${DestinasiEdit.route}/$it") */ }
            )
        }
    }
}
