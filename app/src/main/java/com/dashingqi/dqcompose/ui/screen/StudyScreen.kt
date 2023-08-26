package com.dashingqi.dqcompose.ui.screen

/**
 * @desc : 学习页面
 * @author : zhangqi
 * @time : 2023/8/26 12:53
 */
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dashingqi.dqcompose.ui.components.DQTopAppbar

@Composable
fun StudyScreen() {
    Column {
        DQTopAppbar() {
            Text(text = "学习页面")
        }
        Text(text = "学习页面")
    }

}

@Preview
@Composable
fun StudyScreenPreview() {
    StudyScreen()
}

