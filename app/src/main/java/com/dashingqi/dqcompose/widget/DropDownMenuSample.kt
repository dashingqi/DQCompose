package com.dashingqi.dqcompose.widget

/**
 * @desc :DropDpwnMenu ---> PopupWindow
 * @author : zhangqi
 * @time : 2023/8/6 16:47
 */
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.window.SecureFlagPolicy

@Composable
fun DropDownMenuSample() {

    var dropDownExpandState by remember {
        mutableStateOf(false)
    }

    Column {
        Button(onClick = { dropDownExpandState = true }) {
            Text(text = "点击展示菜单")
        }

        DropdownMenu(
            expanded = dropDownExpandState,
            onDismissRequest = { dropDownExpandState = false },
            properties = PopupProperties(securePolicy = SecureFlagPolicy.SecureOn)
        ) {
            DropdownMenuItem(onClick = {
                dropDownExpandState = false
            }) {
                Text(text = "Item1")
            }

            DropdownMenuItem(onClick = {
                dropDownExpandState = false
            }) {
                Text(text = "Item2")
            }

            DropdownMenuItem(onClick = {
                dropDownExpandState = false

            }) {
                Text(text = "Item3")
            }
        }
    }
}

@Preview
@Composable
fun DDropDownMenuSamplePreview() {
    DropDownMenuSample()
}

