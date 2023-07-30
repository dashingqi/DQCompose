package com.dashingqi.dqcompose.widget

/**
 * @desc : Icon Sample
 * @author : zhangqi
 * @time : 2023/7/30 10:23
 */
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dashingqi.dqcompose.R

@Composable
fun IconSample() {
    // Icon(imageVector = Icons.Default.Home, contentDescription = null, tint = Color.Red)
    IconButton(onClick = { /*TODO*/ }) {
       // Icon(painter = painterResource(id = R.drawable.jsy), contentDescription = null)
        Icon(imageVector = Icons.Default.Home, contentDescription = null, tint = Color.Red)
    }

}

@Preview
@Composable
fun IconSamplePreview() {
    IconSample()
}

