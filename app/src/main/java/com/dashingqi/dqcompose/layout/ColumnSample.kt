package com.dashingqi.dqcompose.layout

/**
 * @desc : Column 列
 * @author : zhangqi
 * @time : 2023/7/30 16:13
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColumnSample() {
    Column(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = " Column First one ", textAlign = TextAlign.Center,modifier = Modifier.padding(10.dp)
        )

        Text(
            text = " Column First two ",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)
                .background(Color.Yellow),
            color = Color.Red
        )

    }

}

@Preview
@Composable
fun ColumnSamplePreview() {
    ColumnSample()
}

