package com.dashingqi.dqcompose.layout

/**
 * @desc : LazyColumn
 * @author : zhangqi
 * @time : 2023/7/31 10:32
 */
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun LazyColumnSample() {

    val data = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 14, 14, 13, 15, 16)
    // 滑动状态
    val lazyState = rememberLazyListState()

    // 协程
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(state = lazyState, modifier = Modifier.background(Color.White)) {
        stickyHeader {
            Text(
                text = "Stick Header",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
        items(data) {
            ListItem(icon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            }, text = {
                Text(text = "Item is $it")
            }, secondaryText = {
                Text(text = "second title")
            }, modifier = Modifier.clickable {
                coroutineScope.launch {
                    lazyState.animateScrollToItem(data.size - 1)
                }
            })

            //可以坚挺条目的生命周期
            DisposableEffect(Unit) {
                Log.d("======", "effect = $it ")
                onDispose {
                    Log.d("======", "onDispose = $it")
                }
            }
        }
    }
}

@Preview
@Composable
fun LazyColumnSamplePreview() {
    LazyColumnSample()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemsSample() {

    val data = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 14, 14, 13, 15, 16)
    // 滑动状态
    val scrollState = rememberScrollState()

    // 协程
    val coroutineScope = rememberCoroutineScope()


    Column(modifier = Modifier.verticalScroll(scrollState)) {
        data.forEach {
            ListItem(icon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            }, text = {
                Text(text = "Item is $it")
            }, secondaryText = {
                Text(text = "second title")
            }, modifier = Modifier.clickable {
                coroutineScope.launch {
                    scrollState.scrollTo(scrollState.maxValue)
                }
            })

            //可以坚挺条目的生命周期
            DisposableEffect(Unit) {
                Log.d("======", "effect = $it ")
                onDispose {
                    Log.d("======", "onDispose = $it")
                }
            }
        }
    }
}

