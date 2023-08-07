package com.dashingqi.dqcompose.layout

/**
 * @desc : Surface
 * @author : zhangqi
 * @time : 2023/8/7 22:19
 */
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dashingqi.dqcompose.R

@Composable
fun SurfaceSample() {
    // CutCornerShape 切角
    // RoundedCornerShape 圆角
    // CircleShape 50%圆角形成胶囊状
    // RectangleShape 矩形
    Surface(
        shape = CutCornerShape(100), border = BorderStroke(1.dp, Color.Yellow), elevation = 10.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.jsy), contentDescription = null
        )
    }
}

@Preview
@Composable
fun SurfaceSamplePreview() {
    SurfaceSample()
}

