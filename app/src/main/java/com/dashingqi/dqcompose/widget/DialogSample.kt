package com.dashingqi.dqcompose.widget

/**
 * @desc : dialog sample
 * @author : zhangqi
 * @time : 2023/8/14 22:09
 */
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
private fun DialogSample() {

    var showDialog by remember {
        mutableStateOf(false)
    }

    Column {
        Button(onClick = {
            // 展示dialog的逻辑
            showDialog = true
        }) {
            Text(text = "show dialog")
        }
        if (showDialog) {
//            Dialog(onDismissRequest = {
//
//                // 背景部分或者返回键是否消失
//                showDialog = false
//            }) {
//                Surface(
//                    color = Color.White, modifier = Modifier.size(200.dp, 100.dp)
//                ) {
//                    Text(text = "Dialog content")
//                }
//
//            }

            AlertDialog(onDismissRequest = {
                // 点击蒙层区域或者返回键dialog不消失
                showDialog = true
            }, title = { Text(text = "AlertDialog") }, confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(text = "confirm")
                }
            }, dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(text = "cancel")
                }
            }, text = {
                Text(text = "dialog content")
            })
        }
    }
}

@Preview
@Composable
fun DialogSamplePreview() {
    DialogSample()
}


@Composable
fun ShowDialogSample() {
    DialogSample()

}

