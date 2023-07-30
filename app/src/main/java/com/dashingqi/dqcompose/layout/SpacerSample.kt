package com.dashingqi.dqcompose.layout

/**
 * @desc : Spacer Sample
 * @author : zhangqi
 * @time : 2023/7/30 16:37
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SpacerSample() {
    Column(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Green)
    ) {
        Text(text = "Column Item One One ...", color = Color.Red)
        Spacer(modifier = Modifier.height(20.dp))
        Divider(startIndent = 3.dp, thickness = 12.dp, color = Color.Magenta)
        Text(text = "Column item two teo   ....", color = Color.Yellow)
    }
}

@Preview
@Composable
fun SpacerSamplePreview() {
    SpacerSample()
}

