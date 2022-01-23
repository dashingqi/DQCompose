package com.dashingqi.dqcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dashingqi.dqcompose.ui.theme.DQComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DQComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
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
        onClick = { /*TODO*/ },
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
