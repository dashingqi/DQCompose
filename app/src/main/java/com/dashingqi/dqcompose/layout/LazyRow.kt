package com.dashingqi.dqcompose.layout

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/8/2 23:01
 */
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyRowSample() {
    val itemList = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    LazyRow() {
        stickyHeader {
            Text(
                text = "lazy row stick header", modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Yellow)
            )
        }
        items(itemList) {
            Text(text = "it is Item --> $it", modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun LazyRowPreview() {
    LazyRowSample()
}

