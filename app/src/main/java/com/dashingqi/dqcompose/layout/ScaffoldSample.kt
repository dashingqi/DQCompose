package com.dashingqi.dqcompose.layout

/**
 * @desc : Scaffold
 * @author : zhangqi
 * @time : 2023/8/7 22:30
 */
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Badge
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldSample() {

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "title", textAlign = TextAlign.Center)
        }, backgroundColor = Color.White, navigationIcon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
        }, actions = {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Edit")
        })
    }, bottomBar = {
        BottomAppBar(backgroundColor = Color.Gray) {

        }
    }, floatingActionButton = {
        ExtendedFloatingActionButton(text = { Text(text = "Mine") }, onClick = { /*TODO*/ })

    }, floatingActionButtonPosition = FabPosition.Center, isFloatingActionButtonDocked = true

    ) {

        Text(text = "Scaffold Body Content")
    }
}

@Composable
fun ScaffoldSampleOne() {
    val navs = listOf<String>("study", "learn", "play")
    var currentNavIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "title", textAlign = TextAlign.Center)
        }, backgroundColor = Color.White, navigationIcon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
        }, actions = {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Edit")
        })
    }, bottomBar = {
        BottomNavigation(backgroundColor = Color.White) {
            navs.forEachIndexed { index, s ->
                BottomNavigationItem(selected = currentNavIndex == index,
                    onClick = { currentNavIndex = index },
                    icon = {
                        Badge()
                        Icon(imageVector = Icons.Default.Email, contentDescription = null)

                    },
                    label = {
                        Text(text = s)
                    })
            }
        }
    }) {

    }
}

@Composable
fun ScaffoldSampleTwo() {

    val navs = listOf<String>("study", "learn", "play")

    var currentNavIndex by remember {
        mutableStateOf(0)
    }

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState, topBar = {
        TopAppBar(title = {
            Text(text = "title", textAlign = TextAlign.Center)
        }, backgroundColor = Color.White, navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }

        }, actions = {
            IconButton(onClick = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "this is snack bar", actionLabel = "done", duration = SnackbarDuration.Long
                    )
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Edit")
        })
    }, bottomBar = {
        BottomNavigation(backgroundColor = Color.White) {
            navs.forEachIndexed { index, s ->
                BottomNavigationItem(selected = currentNavIndex == index,
                    onClick = { currentNavIndex = index },
                    icon = {
                        Badge()
                        Icon(imageVector = Icons.Default.Email, contentDescription = null)

                    },
                    label = {
                        Text(text = s)
                    })
            }
        }
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "This is Scaffold Sample Two")
        }
    }, drawerContent = {
        Text(text = "this is drawer content")
    }, drawerBackgroundColor = Color.White, drawerContentColor = Color.Red, drawerScrimColor = Color.Gray

    )

}

@Preview
@Composable
fun ScaffoldSamplePreview() {
    ScaffoldSampleTwo()
}

