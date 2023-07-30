package com.dashingqi.dqcompose.widget

/**
 * Modifier Sample
 * @desc :
 * @author : zhangqi
 * @time : 2023/7/30 09:21
 */
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val TAG = "ModifierSample"

@Composable
fun ModifierSample() {
    Text(
        text = "Modifier Sample Demo",
        style = TextStyle(background = Color.Yellow),
        modifier = Modifier
            .background(color = Color.Blue)
            .padding(8.dp)
            .clickable {
                Log.d(TAG, "点击到我了");
            },
    )
}

@Preview
@Composable
fun ModifierSamplePreview() {
    ModifierSample()
}

