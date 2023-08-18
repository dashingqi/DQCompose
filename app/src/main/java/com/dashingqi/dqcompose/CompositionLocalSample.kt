package com.dashingqi.dqcompose

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/8/18 22:52
 */
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun CompositionLocalSample() {
    val navController = rememberNavController()
    val user = User(name = "dashingqi")
    CompositionLocalProvider(localActiveUser provides user) {
        NavHost(navController = navController, startDestination = "home") {
            composable(route = "home") {
                HomeScreen {
                    navController.navigate("detail")
                }
            }

            composable(route = "detail") {
                DetailScreen {

                }
            }
        }
    }
}

@Preview
@Composable
fun CompositionLocalSamplePreview() {
    CompositionLocalSample()
}

@Composable
fun HomeScreen(onTap: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = " home ---> ${localActiveUser.current.name}")
        Button(onClick = { onTap.invoke() }) {
            Text(text = "navigate to detail")
        }
    }

}


@Composable
fun DetailScreen(onTap: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = " home ---> ${localActiveUser.current.name}")
    }
}

val localActiveUser = compositionLocalOf<User> { error("user is null") }

data class User(val name: String)