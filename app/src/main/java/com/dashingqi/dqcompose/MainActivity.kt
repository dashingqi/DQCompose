package com.dashingqi.dqcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.dashingqi.dqcompose.tabpage.TabWithPager
import com.dashingqi.dqcompose.ui.screen.MainFrame
import com.dashingqi.dqcompose.ui.theme.DQComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        // 处理不同机型，状态栏不透明问题
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//        // 处理不同机型状态栏颜色
//        window.statusBarColor = Color.Transparent.value.toInt()
        // WindowCompat.setDecorFitsSystemWindows(window, false)

        // 获取状态栏高度
        val resourceID = resources.getIdentifier("status_bar_height", "dimen", "android")
        val statusBarHeight = if (resourceID > 0) {
            resources.getDimensionPixelSize(resourceID)
        } else {
            0
        }
        setContent {
            DQComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    TabWithPager()
                }
            }
        }
    }
}