package com.dashingqi.dqcompose.navigation

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/8/15 22:50
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavSample() {
    val navState = rememberNavController()
    // startDestination，代表路由的启始页面
    NavHost(navController = navState, startDestination = "first") {
        composable(route = "first") {
            FirstScreen {
                navState.navigate("second/dashing/27")
            }
        }

        composable(route = "second/{name}/{age}", arguments = listOf(navArgument("age") {
            type = NavType.IntType
        })) {
            val name = it.arguments?.getString("name")
            val age = it.arguments?.getInt("age") ?: 18
            SecondScreen(name, age) {
                navState.navigate("third?=carName=")
            }
        }

        composable(route = "third?=carName={carName}", arguments = listOf(navArgument("carName") {
            defaultValue = "BWA"
            nullable = true
        })) {
            val carName = it.arguments?.getString("carName")
            ThirdScreen(carName) {
                navState.popBackStack("first", inclusive = false)
            }
        }
    }
}

@Composable
fun FirstScreen(onNavAction: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "first page")
        Button(onClick = { onNavAction.invoke() }) {
            Text(text = "go to second page")
        }
    }
}


@Composable
fun SecondScreen(name: String?, age: Int, onNavAction: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "second page ---> $name---> $age")
        Button(onClick = { onNavAction.invoke() }) {
            Text(text = "go to third page")
        }
    }

}


@Composable
fun ThirdScreen(carName: String?, onNavAction: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "third page ---> $carName")
        Button(onClick = { onNavAction.invoke() }) {
            Text(text = "go to first page")
        }
    }
}


@Preview
@Composable
fun NavSamplePreview() {
    NavSample()
}

