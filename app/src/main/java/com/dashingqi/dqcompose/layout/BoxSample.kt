package com.dashingqi.dqcompose.layout

/**
 * @desc : Box Sample
 * @author : zhangqi
 * @time : 2023/7/30 16:03
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxSample() {
//    Box() {
//
//        Box(
//            modifier = Modifier
//                .size(200.dp)
//                .background(Color.Red)
//        )
//        Text(
//            text = "zhangqi", modifier = Modifier
//                .padding(7.dp)
//                .background(Color.Yellow)
//                .size(12.dp)
//                .align(Alignment.Center)
//        )
//        Text(
//            text = "dashingqi", modifier = Modifier
//                .padding(7.dp)
//                .background(Color.Green)
//                .size(8.dp)
//        )
//    }

    BoxWithConstraints {
        if (maxWidth > maxHeight) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Red)
            )
        } else {

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Yellow)
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun BoxSamplePreview() {
    BoxSample()
}

