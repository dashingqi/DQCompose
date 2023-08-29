package com.dashingqi.dqcompose.tabpage

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/8/29 22:34
 */
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabWithPager() {
    val pagerState = rememberPagerState()
    val tabs = listOf<String>("首页", "数学", "语文", "英语", "政治", "历史")
    val tabCoroutine = rememberCoroutineScope()
    Scaffold(topBar = {
        TopAppBar {
            Text(text = "Tab with page")
        }
    }) {
        Column(modifier = Modifier.fillMaxSize()) {
            ScrollableTabRow(selectedTabIndex = pagerState.currentPage) {
                tabs.forEachIndexed { index, s ->
                    Tab(selected = pagerState.currentPage == index, onClick = {
                        tabCoroutine.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }, text = {
                        Text(text = s)
                    })
                }
            }
            HorizontalPager(count = tabs.size, state = pagerState) {
                Text(text = "current page is $it")

            }
        }
    }
}

@Preview
@Composable
fun TabWithPagerPreview() {
    TabWithPager()
}

