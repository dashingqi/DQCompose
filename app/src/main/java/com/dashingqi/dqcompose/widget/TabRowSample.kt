package com.dashingqi.dqcompose.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * @desc : Compose 中TabRow的使用
 * @author : zhangqi
 * @time : 2022/3/6 17:02
 */

@Preview
@Composable
fun TabRowPreView() {
    TabRowSample()

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TabRowSample() {
    Column {

        var selectedIndex by remember {
            mutableStateOf(0)
        }

        TabRow(
            selectedTabIndex = selectedIndex,
            indicator = {},
            backgroundColor = Color(0xFFFFFFFF)
        ) {

            Tab(
                selected = selectedIndex == 0,
                onClick = { selectedIndex = 0 },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Black
            ) {
                Text(text = "Tab0")

            }

            Tab(
                selected = selectedIndex == 1,
                onClick = { selectedIndex = 1 },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null
                    )
                },
                text = {
                    Text(text = "Tab1")
                }
            )


            // 这是一个不稳定的api
            LeadingIconTab(
                selected = selectedIndex == 2,
                onClick = { selectedIndex = 2 },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null
                    )
                },
                text = {
                    Text(text = "Tab3")
                })
        }

        Text(text = "current index is $selectedIndex")
    }

}