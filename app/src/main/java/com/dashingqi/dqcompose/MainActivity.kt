package com.dashingqi.dqcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    TwoTexts(text1 = "Hi", text2 = "DashingQi")
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

@Composable
fun TwoTexts(
    text1: String,
    text2: String,
    modifier: Modifier = Modifier
) {
    Row(
        // height(IntrinsicSize.Min) 强行将子项高度高度调整为最小固有高度
        modifier = modifier
            .height(IntrinsicSize.Min)
    ) {
        Text(
            text = text1,
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .wrapContentWidth(Alignment.Start)
        )

        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )

        Text(
            text = text2, modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
                .wrapContentWidth(Alignment.End)
        )
    }

}