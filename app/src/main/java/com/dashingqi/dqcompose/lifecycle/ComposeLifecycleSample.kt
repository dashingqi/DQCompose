package com.dashingqi.dqcompose.lifecycle

/**
 * LifeCycle-Compose
 * @author zhangqi61
 * @since 2023/8/17
 */
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
private fun ComposeLifecycleSample() {

    var countState by remember {
        mutableStateOf(0)
    }
    Column {

        LaunchedEffect("countState") {
            Log.d("TAG", "perform --->  launched effect")
        }

        Log.d("TAG", "perform ---> ")
        Text(text = "我叫了${countState}个小姐姐")
        Button(onClick = {
            countState++
        }) {
            Text(text = "点我")
        }
    }
}

@Preview
@Composable
fun ComposeLifecycleSamplePreview() {
    ComposeLifecycleSample()
}

@Composable
fun LifecycleSampleOut() {
    ComposeLifecycleSample()
}

