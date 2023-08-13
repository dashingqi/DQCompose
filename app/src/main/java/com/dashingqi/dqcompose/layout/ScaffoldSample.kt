package com.dashingqi.dqcompose.layout

/**
 * @desc : Scaffold
 * @author : zhangqi
 * @time : 2023/8/7 22:30
 */
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.Badge
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScaffoldSampleThree() {
    val scaffoldState = rememberScaffoldState()
    val rememberBackdropScaffoldState = rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed)
    val coroutineScope = rememberCoroutineScope()
    BackdropScaffold(scaffoldState = rememberBackdropScaffoldState, appBar = {
        TopAppBar(title = {
            Text(text = "title", textAlign = TextAlign.Center)
        }, backgroundColor = Color.White, navigationIcon = {
            IconButton(onClick = {
                if (rememberBackdropScaffoldState.isConcealed) {
                    coroutineScope.launch {
                        rememberBackdropScaffoldState.reveal()
                    }
                } else {
                    coroutineScope.launch {
                        rememberBackdropScaffoldState.conceal()

                    }
                }

            }) {
                if (rememberBackdropScaffoldState.isConcealed) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                } else {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
            }

        }, actions = {
            IconButton(onClick = {
                coroutineScope.launch {
                    rememberBackdropScaffoldState.snackbarHostState.showSnackbar(
                        message = "this is snack bar", actionLabel = "done", duration = SnackbarDuration.Long
                    )
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Edit")
        })
    }, frontLayerContent = {
        Text(text = "frontLayerContent")
    }, backLayerContent = {
        LazyColumn {
            items(50) {
                ListItem(text = { Text(text = "item$it") })
            }
        }
    })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScaffoldSampleFour() {

    val scaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp), contentAlignment = Alignment.Center
            ) {
                Text(text = "Swipe up to expand sheet")
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(64.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Sheet Content")
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    coroutineScope.launch {
                        scaffoldState.bottomSheetState.collapse()
                    }
                }) {
                    Text(text = "close")
                }


            }

        },
        sheetPeekHeight = 128.dp,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(text = "Box Content")
            }
        },
        topBar = {
            TopAppBar(title = {
                Text(text = "title", textAlign = TextAlign.Center)
            }, backgroundColor = Color.White, navigationIcon = {
                IconButton(onClick = {}) {
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
        },
    )
}

@Preview
@Composable
fun ScaffoldSamplePreview() {
    ScaffoldSampleFour()
}

@Composable
fun ScaffoldSampleOut() {
    ScaffoldSampleFour()
}

