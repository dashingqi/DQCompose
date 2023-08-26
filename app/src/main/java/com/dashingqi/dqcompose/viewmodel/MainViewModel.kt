package com.dashingqi.dqcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dashingqi.dqcompose.model.entity.Category

/**
 * @desc : 主页面的ViewModel
 * @author : zhangqi
 * @time : 2023/8/26 22:32
 */
class MainViewModel : ViewModel() {

    /** tab分类*/
    val categories = mutableStateOf(
        listOf(
            Category("思想政治"), Category("法律法规"), Category("职业道德"), Category("诚信自律")
        )
    )


    /** 当前分类下标*/
    val categoryIndex = mutableStateOf(0)

    fun updateCategoryIndex(index: Int) {
        categoryIndex.value = index
    }


}