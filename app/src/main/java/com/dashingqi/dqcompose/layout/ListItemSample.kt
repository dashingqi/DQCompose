package com.dashingqi.dqcompose.layout

/**
 * @desc :ListItem Sample
 * @author : zhangqi
 * @time : 2023/7/30 22:24
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemSample() {
    val listItem = listOf("Item 0", "Item 1", "Item 2", "Item3")
    Column(modifier = Modifier.background(Color.White)) {
        listItem.forEach { item ->
            ListItem(icon = {
                Box(contentAlignment = Alignment.Center) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = null)
                }

            }, text = {
                Text(text = item)
            }, secondaryText = {
                Text(text = "Second Text")
            })
        }
    }
}

@Preview
@Composable
fun ListItemSamplePreview() {
    ListItemSample()
}

