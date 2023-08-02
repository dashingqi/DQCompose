package com.dashingqi.dqcompose.layout

/**
 * @desc : LazyVerticalGrid
 * @author : zhangqi
 * @time : 2023/8/2 23:08
 */
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalGridSample() {

    val itemList = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    Column {


        LazyVerticalGrid(cells = GridCells.Fixed(3),content = {
            items(itemList) {
                Card {
                    Text(text = "Item is $it", modifier = Modifier.padding(8.dp), textAlign = TextAlign.Center)
                }
            }
        })

        LazyVerticalGrid(cells = GridCells.Adaptive(150.dp)) {
            items(itemList) {
                Card {
                    Text(text = "Item is $it", modifier = Modifier.padding(8.dp), textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@Preview
@Composable
fun LazyVerticalGridSamplePreview() {
    LazyVerticalGridSample()
}

