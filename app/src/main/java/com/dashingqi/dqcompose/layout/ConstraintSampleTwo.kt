package com.dashingqi.dqcompose.layout

/**
 * @desc : constraint layout two
 * @author : zhangqi
 * @time : 2023/8/6 16:14
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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun ConstraintSampleTwo() {


    /**
     * 声明约束Id以及约束关系
     */
    val constraint = ConstraintSet {
        val icon = createRefFor("icon")

        val primaryText = createRefFor("primaryText")

        val secondlyText = createRefFor("secondlyText")

        val checkBoxState = createRefFor("checkBoxState")

        constrain(icon) {
            this.start.linkTo(parent.start, margin = 4.dp)
            this.bottom.linkTo(parent.bottom)
            this.top.linkTo(parent.top)

        }

        constrain(primaryText) {
            this.start.linkTo(icon.end,4.dp)

        }

        constrain(secondlyText) {
            this.start.linkTo(primaryText.start)
            this.top.linkTo(primaryText.bottom)

        }

        constrain(checkBoxState) {
            this.end.linkTo(parent.end, margin = 4.dp)
            this.bottom.linkTo(parent.bottom)
            this.top.linkTo(parent.top)
        }

    }



    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White), constraintSet = constraint
    ) {

        var checked by remember {
            mutableStateOf(false)
        }
        Icon(imageVector = Icons.Default.AccountBox, contentDescription = null, Modifier.layoutId("icon"))

        Text(
            text = "Item0", fontWeight = FontWeight.Bold, fontSize = 16.sp,
            modifier = Modifier.layoutId("primaryText")
        )

        Text(
            text = "secondly Text", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.layoutId("secondlyText")
        )

        Checkbox(checked = checked, onCheckedChange = {
            checked = it
        }, modifier = Modifier.layoutId("checkBoxState"))
    }
}

@Preview
@Composable
fun ConstraintSampleTwoPreview() {
    ConstraintSampleTwo()
}

