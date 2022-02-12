package com.dashingqi.dqcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dashingqi.dqcompose.ui.theme.DQComposeTheme
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DQComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                  UseSnackBar()

                    UseButton()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name! DashingQi")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DQComposeTheme {
        Greeting("Android")
    }
}

/**
 * 垂直排列
 */
@Preview(showBackground = true)
@Composable
fun ColumnUse() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Hello",
            modifier = Modifier.wrapContentHeight()
        )
        Text(
            text = "DashingQi",
            modifier = Modifier.fillMaxWidth(),

            )
    }
}

/**
 * 横向排列
 */
@Preview(showBackground = true)
@Composable
fun RowUse() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "HEAD")
        Column {
            Text(text = "Hello")
            Text(text = "Compose")
        }
    }
}


/**
 * Box可以将元素放到其他元素之上
 */
@Preview(showBackground = true)
@Composable
fun UseBox() {
    Box {
        Text(text = "dashing qi")
    }
}

@Preview(showBackground = true)
@Composable
fun UseBoxWithConstraints() {
    BoxWithConstraints {
        Text(text = "My minHeight is while my maxWidth is ")
    }
}

@Preview(showBackground = true)
@Composable
fun UseButton() {

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            Log.d(TAG, "click like button");
        },
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {

        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Like")

    }
}

@Preview(showBackground = true)
@Composable
fun UseExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        text = { Text(text = "Like") },
        onClick = {},
        icon = {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite"
            )
        })
}

@Preview(showBackground = true)
@Composable
fun UseScaffold() {
    Scaffold(topBar = {
        TopAppBar {

        }
    }, bottomBar = {
        BottomAppBar(
            cutoutShape = MaterialTheme.shapes.small.copy(
                CornerSize(percent = 50)
            )
        ) {

        }
    }, floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Text(text = "FAB")
        }
    }, floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        Column {
            UseExtendedFloatingActionButton()
            UseButton()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UseSnackBar() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "show snackBar") },
                onClick = {
                    scope.launch {
                        val result = scaffoldState.snackbarHostState.showSnackbar(
                            message = "SnackBar",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Indefinite
                        )

                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                Log.d(TAG, "UseSnackBar: ActionPerformed")

                            }
                            SnackbarResult.Dismissed -> {
                                Log.d(TAG, "UseSnackBar: Dismissed")
                            }
                        }
                    }
                })
        },
        drawerContent = {

        }
    ) {

    }
}
