package com.dashingqi.dqcompose.layout

/**
 * @desc : constraint layout sample
 * @author : zhangqi
 * @time : 2023/8/6 15:42
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintSample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        var checked by remember {
            mutableStateOf(false)
        }

        val (icon, primaryText, secondlyText, checkBoxState) = createRefs()
        Icon(imageVector = Icons.Default.AccountBox, contentDescription = null, modifier = Modifier.constrainAs(icon) {
            // 写约束条件
            top.linkTo(parent.top, 12.dp)
            start.linkTo(parent.start, 10.dp)
        })

        Text(text = "Item0",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(primaryText) {
                top.linkTo(icon.top)
                start.linkTo(icon.end, 4.dp)

            })

        Text(text = "secondly Text",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.constrainAs(secondlyText) {
                start.linkTo(primaryText.start)
                top.linkTo(primaryText.bottom, 4.dp)

            })

        Checkbox(checked = checked, onCheckedChange = {
            checked = it
        }, modifier = Modifier.constrainAs(checkBoxState) {
            centerVerticallyTo(parent)
            end.linkTo(parent.end, margin = 5.dp)

        })
    }
}

@Preview
@Composable
fun ConstraintSamplePreview() {
    ConstraintSample()
}

