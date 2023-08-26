package com.dashingqi.dqcompose.ui.screen

/**
 * @desc : 学习页面
 * @author : zhangqi
 * @time : 2023/8/26 12:53
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dashingqi.dqcompose.ui.components.DQTopAppbar
import com.dashingqi.dqcompose.viewmodel.MainViewModel

@Composable
fun StudyScreen(vm: MainViewModel = viewModel()) {
    Column {
        DQTopAppbar(modifier = Modifier.padding(horizontal = 8.dp)) {
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f), color = Color(0x33FFFFFF)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "搜索感兴趣的资讯或课程",
                        color = Color.White,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "学习\n进度", fontSize = 10.sp, color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "26%", fontSize = 12.sp, color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Default.Notifications, contentDescription = null, tint = Color.White)
        }
        TabRow(
            selectedTabIndex = vm.categoryIndex.value,
            backgroundColor = Color(0x66149EE7),
            contentColor = Color(0xFF149EE7)
        ) {
            vm.categories.value.forEachIndexed { index, category ->
                Tab(
                    selected = vm.categoryIndex.value == index, onClick = {
                        vm.updateCategoryIndex(index)
                    }, selectedContentColor = Color(0x66149EE7), unselectedContentColor = Color(0xFF666666)
                ) {
                    Text(text = category.title, modifier = Modifier.padding(vertical = 8.dp), fontSize = 14.sp)
                }
            }

        }
    }

}

@Preview
@Composable
fun StudyScreenPreview() {
    StudyScreen()
}

