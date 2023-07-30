package com.dashingqi.dqcompose.layout

/**
 * @desc : row sample
 * @author : zhangqi
 * @time : 2023/7/30 16:29
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RowSample() {
    Row(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Green),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Row item one ", color = Color.Red, modifier = Modifier.weight(1f), textAlign = TextAlign.Center
        )
        Text(
            text = "Row item two", color = Color.Yellow, modifier = Modifier.weight(1f), textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun RowSamplePreview() {
    RowSample()
}

