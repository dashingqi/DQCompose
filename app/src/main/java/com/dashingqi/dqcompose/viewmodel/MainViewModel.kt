package com.dashingqi.dqcompose.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.VideoStable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dashingqi.dqcompose.model.entity.CategoryEntity
import com.dashingqi.dqcompose.model.entity.MainBannerEntity
import com.dashingqi.dqcompose.model.entity.MainTypeEntity

/**
 * @desc : 主页面的ViewModel
 * @author : zhangqi
 * @time : 2023/8/26 22:32
 */
class MainViewModel : ViewModel() {

    /** tab分类*/
    val categories = mutableStateOf(
        listOf(
            CategoryEntity("思想政治"),
            CategoryEntity("法律法规"),
            CategoryEntity("职业道德"),
            CategoryEntity("诚信自律")
        )
    )


    /** 当前分类下标*/
    val categoryIndex = mutableStateOf(0)

    /**
     * 更新分类下标
     */
    fun updateCategoryIndex(index: Int) {
        categoryIndex.value = index
    }

    val types by lazy {
        mutableStateOf(
            listOf(
                MainTypeEntity("相关资讯", Icons.Default.Description),
                MainTypeEntity("视频课程", Icons.Default.VideoStable)
            )
        )
    }

    val typeIndex = mutableStateOf(0)

    /**
     * 更新类型下标
     */
    internal fun updateTypeIndex(index: Int) {
        typeIndex.value = index
    }

    /**
     * 轮播图
     */
    val bannerItems by lazy {
        listOf(
            MainBannerEntity("https://cdn3-banquan.ituchong.com/weili/image/l/902482434080374789.jpeg"),
            MainBannerEntity("https://cdn9-banquan.ituchong.com/weili/image/l/913531555272720442.jpeg"),
            MainBannerEntity("https://cdn6-banquan.ituchong.com/weili/image/l/1204285688645419034.jpeg"),
            MainBannerEntity("https://cdn3-banquan.ituchong.com/weili/image/l/1481175667509952526.jpeg"),
            MainBannerEntity("https://cdn6-banquan.ituchong.com/weili/l/840614942016012294.jpeg")
        )
    }


}