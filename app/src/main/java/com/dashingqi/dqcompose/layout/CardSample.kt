package com.dashingqi.dqcompose.layout

/**
 * @desc : Card Sample
 * @author : zhangqi
 * @time : 2023/7/30 15:54
 */
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardSample() {
    Card(
        modifier = Modifier.padding(10.dp),
        backgroundColor = Color.Green,
        contentColor = Color.Yellow,
        border = BorderStroke(1.dp, Color.Red),
        elevation = 10.dp,

    ) {
        Text(
            text = "this is card layout",
            modifier = Modifier.padding(12.dp)
        )

    }
}

@Preview
@Composable
fun CardSamplePreview() {
    CardSample()
}

