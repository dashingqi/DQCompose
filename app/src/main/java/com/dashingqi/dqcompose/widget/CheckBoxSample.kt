package com.dashingqi.dqcompose.widget

/**
 * @desc : CheckBox Sample
 * @author : zhangqi
 * @time : 2023/7/30 22:17
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxSample() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(200f.dp)
            .background(color = Color.Red)
    ) {
        var checked by remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checked, onCheckedChange = {
            checked = it
        })
    }
}

@Preview
@Composable
fun CheckBoxSamplePreview() {
    CheckBoxSample()
}

