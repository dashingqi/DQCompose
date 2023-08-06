package com.dashingqi.dqcompose.layout

/**
 * @desc : TabRow --> TabLayout
 * @author : zhangqi
 * @time : 2023/8/6 16:25
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Icon
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TabRowSample() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(
        Modifier
            .fillMaxHeight()
            .background(Color.White)
    ) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            // 自定义做法
//            Text(
//                text = "Tab1", textAlign = TextAlign.Center, modifier = Modifier
//                    .padding(4.dp)
//                    .clickable {
//                        selectedTabIndex = 0
//                    }, color = if (selectedTabIndex == 0) Color.Blue else Color.White
//            )
//            Text(
//                text = "Tab2", textAlign = TextAlign.Center, modifier = Modifier
//                    .padding(4.dp)
//                    .clickable {
//                        selectedTabIndex = 1
//                    }, color = (if (selectedTabIndex == 1) Color.Blue else Color.White)
//            )
//            Text(
//                text = "Tab3", textAlign = TextAlign.Center, modifier = Modifier
//                    .padding(4.dp)
//                    .clickable {
//                        selectedTabIndex = 2
//                    }, color = if (selectedTabIndex == 2) Color.Blue else Color.White
//            )

            // 系统用法
            Tab(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }) {
                Text(text = "Tab1")

            }

            Tab(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }, icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox, contentDescription = null
                )
            }, text = {
                Text(text = "Tab2")
            })

            LeadingIconTab(selected = selectedTabIndex == 2, onClick = { selectedTabIndex = 2 }, icon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            }, text = {
                Text(text = "Tab2")
            })
        }
        Text(text = "current index is =$selectedTabIndex")
    }
}

@Preview
@Composable
fun TabRowSamplePreview() {
    TabRowSample()
}

