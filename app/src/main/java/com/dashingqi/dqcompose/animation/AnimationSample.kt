package com.dashingqi.dqcompose.animation

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/8/19 15:57
 */
import android.widget.Space
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dashingqi.dqcompose.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationSample() {
    var visible by remember {
        mutableStateOf(false)
    }
    Column {
        Button(onClick = {
            visible = !visible
        }) {
            Text(text = "click")
        }
        AnimatedVisibility(visible = visible, enter = EnterTransition.None) {
            // Image(painter = painterResource(id = R.drawable.jsy), contentDescription = null)

            Box(
                modifier = Modifier
                    .size(220.dp)
                    .background(Color.Yellow)
            ) {
                Box(
                    modifier = Modifier
                        .animateEnterExit(
                            enter = slideInVertically(tween(1000)), exit = slideOutVertically()
                        )
                        .align(Alignment.Center)
                        .size(150.dp)
                        .background(Color.Red)
                )
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationSample2() {
    var count by remember {
        mutableStateOf(0)
    }
    Row {
        Button(onClick = { count++ }) {
            Text(text = "Add")
        }
        Spacer(modifier = Modifier.width(5.dp))

        Button(onClick = { count-- }) {
            Text(text = "reduce")
        }
        Spacer(modifier = Modifier.width(5.dp))
        AnimatedContent(targetState = count, transitionSpec = {
            if (targetState > initialState) {
                slideInVertically { fullHeight -> fullHeight } + fadeIn() with slideOutVertically { fullHeight -> -fullHeight } + fadeOut()

            } else {
                slideInVertically { fullHeight -> -fullHeight } + fadeIn() with slideOutVertically { fullHeight -> fullHeight } + fadeOut()
            }
        }) {
            Text(text = "count --> $it")
        }

    }

}

@Composable
fun AnimationSample5() {

    var size by remember {
        mutableStateOf(30.dp)
    }

    val sizeAnimation by animateDpAsState(targetValue = size, animationSpec = spring(Spring.DampingRatioHighBouncy))
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier
                .size(sizeAnimation)
                .clickable(interactionSource = MutableInteractionSource(), indication = null) {
                    size += 20.dp
                })

    }
}

@Preview
@Composable
fun AnimationSamplePreview() {
    AnimationSample5()
}

