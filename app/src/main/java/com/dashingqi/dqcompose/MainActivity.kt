package com.dashingqi.dqcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.dashingqi.dqcompose.ui.theme.DQComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DQComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //ConstraintLayoutUse()

                    DecoupledConstraintLayout()
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
 * ConstraintLayout 在Compose中使用
 */
@Composable
fun ConstraintLayoutUse() {
    ConstraintLayout {

        val (button, text) = createRefs()
        Button(onClick = { },
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        )
        {
            Text(text = "Button")
        }

        Text(text = "我在Button下面呢", modifier = Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 8.dp)
            start.linkTo(button.start)
            end.linkTo(button.end)
        })
    }
}

@Composable
fun DecoupledConstraintLayout() {

    BoxWithConstraints {
        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp)
        } else {
            decoupledConstraints(margin = 32.dp)
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .layoutId("button")
            ) {
                Text(text = "这是一个按钮")
            }

            Text(text = "这是一段文本", modifier = Modifier.layoutId("text"))
        }
    }

}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")
        constrain(button) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start, margin = 16.dp)
            end.linkTo(parent.end, margin = 16.dp)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
            start.linkTo(button.start)
            end.linkTo(button.end)
        }
    }

}