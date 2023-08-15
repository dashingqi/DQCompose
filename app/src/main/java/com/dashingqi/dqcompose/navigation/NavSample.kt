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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavSample() {
    val navState = rememberNavController()
    // startDestination，代表路由的启始页面
    NavHost(navController = navState, startDestination = "first") {
        composable(route = "first") {
            FirstScreen {
                navState.navigate("second")
            }
        }

        composable(route = "second") {
            SecondScreen {
                navState.navigate("third")
            }
        }

        composable(route = "third") {
            ThirdScreen {
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
fun SecondScreen(onNavAction: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "second page")
        Button(onClick = { onNavAction.invoke() }) {
            Text(text = "go to third page")
        }
    }

}


@Composable
fun ThirdScreen(onNavAction: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "third page")
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

