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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


private const val TAG = "LifecycleTag"

@Composable
private fun ComposeLifecycleSample(lifecycleOwner: LifecycleOwner) {

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

    val lifecycle = lifecycleOwner.lifecycle
    DisposableEffect(lifecycleOwner) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    Log.d(TAG, "ON_START perform ---> ")
                }

                Lifecycle.Event.ON_DESTROY -> {
                    Log.d(TAG, "ON_DESTROY perform ---> ")
                }

                Lifecycle.Event.ON_CREATE -> {
                    Log.d(TAG, "ON_CREATE perform ---> ")
                }

                Lifecycle.Event.ON_RESUME -> {
                    Log.d(TAG, "ON_RESUME perform ---> ")
                }

                Lifecycle.Event.ON_STOP -> {
                    Log.d(TAG, "ON_STOP perform ---> ")
                }

                else -> {

                }
            }
        }
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }

}

@Preview
@Composable
fun ComposeLifecycleSamplePreview() {
    ComposeLifecycleSample(LocalLifecycleOwner.current)
}

@Composable
fun LifecycleSampleOut(lifecycleOwner: LifecycleOwner) {
    ComposeLifecycleSample(lifecycleOwner)
}

