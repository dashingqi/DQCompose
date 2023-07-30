package com.dashingqi.dqcompose.widget

/**
 * @desc : Button Sample
 * @author : zhangqi
 * @time : 2023/7/30 09:51
 */
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private const val TAG = "ButtonSample"

@Composable
fun ButtonSample() {
//    Button(
//        onClick = { Log.d(TAG, "你点击我了"); }, colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.Blue, contentColor = Color.Yellow
//        ), border = BorderStroke(Dp(2f), Color.Gray), enabled = true
//    ) {
//        Text(text = "这是一个按钮")
//    }
    // 简单的文本按钮
//    TextButton(onClick = {}) {
//        Text(text = "this is text button")
//
//    }

    //带有边框的Button
    OutlinedButton(onClick = { /*TODO*/ }) {
        Text(text = "我是中国人")
    }
}

@Preview
@Composable
fun ButtonSamplePreview() {
    ButtonSample()
}

