package com.dashingqi.dqcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.dashingqi.dqcompose.layout.ScaffoldSample
import com.dashingqi.dqcompose.layout.ScaffoldSampleOne
import com.dashingqi.dqcompose.layout.ScaffoldSampleOut
import com.dashingqi.dqcompose.layout.ScaffoldSampleThree
import com.dashingqi.dqcompose.layout.ScaffoldSampleTwo
import com.dashingqi.dqcompose.ui.theme.DQComposeTheme
import com.dashingqi.dqcompose.widget.DropDownMenuSample
import com.dashingqi.dqcompose.widget.MyViewModel
import com.dashingqi.dqcompose.widget.ShowDialogSample


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        setContent {
//            MessageCard(name = "My Android")
            DQComposeTheme {
                ShowDialogSample()
            }
        }
    }
}

@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name")
}

@Preview
@Composable

fun PreviewMessageCard() {
    MessageCard(name = "My Android")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MessageList() {
    LazyColumn(
        // 内容边缘添加内边距
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        // 列表项之间添加间距
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 实验性
        stickyHeader {
            Text(text = "这是一个粘性标题")
        }
        items(50) { index ->
            Text(text = "Item $index")
        }
    }
}