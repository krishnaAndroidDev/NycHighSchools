package com.test.nycschools

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.nycschools.domain.HighSchoolViewModel
import com.test.nycschools.ui.HighSchoolListClass.HighSchoolDetail
import com.test.nycschools.ui.HighSchoolListClass.HighSchoolList

@Composable
fun Navigation(startDestination: String = "highSchoolList") {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("highSchoolList") {
            HighSchoolListScreen(navController)
        }
        composable("highSchoolDetail/{schoolId}") { backStackEntry ->
            HighSchoolDetailScreen(
                navController,
                schoolId = backStackEntry.arguments?.getString("schoolId") ?: ""
            )
        }
    }
}

@Composable
fun HighSchoolListScreen(navController: NavController) {
    val viewModel: HighSchoolViewModel = viewModel()
    val highSchools by viewModel.highSchools.observeAsState(emptyList())

    HighSchoolList(
        highSchool = highSchools,
        onItemClick = { school ->
            navController.navigate("highSchoolDetail/${school.dbn}")
        }
    )
}

@Composable
fun HighSchoolDetailScreen(navController: NavController, schoolId: String) {
    val viewModel: HighSchoolViewModel = viewModel()
    val highSchool = viewModel.highSchools.value?.find { it.dbn == schoolId }
    highSchool?.let {
        HighSchoolDetail(it)
    } ?: run {
        // Handle error or loading state
    }
}