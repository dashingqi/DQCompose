package com.dashingqi.dqcompose.ui.screen

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/8/26 11:39
 */
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dashingqi.dqcompose.model.entity.BottomNavigationItem

@Composable
fun MainFrame() {

    val items by lazy {
        listOf(
            BottomNavigationItem(
                title = "首页", icon = Icons.Default.Home
            ), BottomNavigationItem(
                title = "任务", icon = Icons.Default.DateRange
            ), BottomNavigationItem(
                title = "我的", icon = Icons.Default.Person
            )
        )
    }

    var currentNavigationState by remember {
        mutableStateOf(0)
    }

    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
            items.forEachIndexed { index, bottomNavigationItem ->
                BottomNavigationItem(
                    selected = currentNavigationState == index,
                    onClick = {
                        currentNavigationState = index
                    },
                    icon = {
                        Icon(imageVector = bottomNavigationItem.icon,
                            contentDescription = null)
                    },
                    label = {
                        Text(text = bottomNavigationItem.title)
                    },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF999999),
                    alwaysShowLabel = false
                )
            }
        }
    }) {
        Text(text = "current bottom navigation index is $currentNavigationState")
    }
}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame()
}

