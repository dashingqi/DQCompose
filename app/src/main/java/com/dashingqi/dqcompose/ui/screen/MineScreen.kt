package com.dashingqi.dqcompose.ui.screen

/**
 * @desc : 我的页面
 * @author : zhangqi
 * @time : 2023/8/26 12:54
 */
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dashingqi.dqcompose.ui.components.DQTopAppbar

@Composable
fun MineScreen() {
    Column {
        DQTopAppbar() {
            Text(text = "我的页面")
        }
        Text(text = "我的页面")
    }
}

@Preview
@Composable
fun MineScreenPreview() {
    MineScreen()
}

