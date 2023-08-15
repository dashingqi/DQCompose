package com.dashingqi.dqcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.ComposeView

import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModelProvider
import com.dashingqi.dqcompose.layout.ScaffoldSample
import com.dashingqi.dqcompose.layout.ScaffoldSampleOne
import com.dashingqi.dqcompose.layout.ScaffoldSampleOut
import com.dashingqi.dqcompose.layout.ScaffoldSampleThree
import com.dashingqi.dqcompose.layout.ScaffoldSampleTwo
import com.dashingqi.dqcompose.navigation.NavSample
import com.dashingqi.dqcompose.ui.theme.DQComposeTheme
import com.dashingqi.dqcompose.widget.DropDownMenuSample
import com.dashingqi.dqcompose.widget.MyViewModel
import com.dashingqi.dqcompose.widget.ShowDialogSample


class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main)
        // 在 xml 中使用 ComposeView
//        val composeView = findViewById<ComposeView>(R.id.composeView)
//        composeView.setContent {
//            Column {
//                Text(text = "compose view text")
//                AndroidView(factory = {
//                    // 在 Compose 中使用原生 View || LayoutInflater.inflate()
//                    TextView(it)
//                }) {
//                    it.apply {
//                        text = "Compose中使用原生View"
//                    }
//                }
//            }
//        }

        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        setContent {
//            MessageCard(name = "My Android")
            DQComposeTheme {
               NavSample()
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