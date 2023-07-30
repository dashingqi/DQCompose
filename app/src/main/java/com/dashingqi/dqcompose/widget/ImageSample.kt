package com.dashingqi.dqcompose.widget

/**
 * @desc : Image Sample
 * @author : zhangqi
 * @time : 2023/7/30 10:32
 */
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dashingqi.dqcompose.R

@Composable
fun ImageSample() {
    Image(
        painter = painterResource(id = R.drawable.jsy),
        contentDescription = null,
        modifier = Modifier.size(200.dp),
        // 裁剪方式
        contentScale = ContentScale.Crop,
        // 滤镜
        colorFilter = ColorFilter.tint(Color.Yellow, blendMode = BlendMode.Color)
    )
}

@Preview
@Composable
fun ImageSamplePreview() {
    ImageSample()
}

