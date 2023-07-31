package com.dashingqi.dqcompose.widget

/**
 * @desc : RadioButton Sample
 * @author : zhangqi
 * @time : 2023/7/30 22:00
 */
import androidx.compose.foundation.layout.Column
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun RadioButtonSample() {
    Column {
        var selected by remember {
            mutableStateOf(false)
        }
        RadioButton(selected = selected, onClick = {
            selected = !selected
        })

        var checkedList by remember {
            mutableStateOf(listOf(false, false))
        }

        Column {
            checkedList.forEachIndexed { i, item ->
                RadioButton(selected = item, onClick = {
                    checkedList = checkedList.mapIndexed { j, b ->
                        i == j
                    }
                })
            }
        }
    }
}

@Preview
@Composable
fun RadioButtonSamplePreview() {
    RadioButtonSample()
}

