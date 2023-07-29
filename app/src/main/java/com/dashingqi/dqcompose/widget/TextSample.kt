package com.dashingqi.dqcompose.widget

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.sp
import com.dashingqi.dqcompose.R

/**
 * @desc : Text组件
 * @author : zhangqi
 * @time : 2023/7/29 16:35
 * comp 快捷键
 * 方法首字母大写
 */
@Composable
fun TextSample() {
//    Text(text = "我终于要学会 Jetpack Compose 了")
    // 长按选中
    SelectionContainer {
        Text(
            // 文字内容
            text = stringResource(id = R.string.text),
            // 文字颜色
            color = Color.Red,
            // 文字大小
            fontSize = 14f.sp, //TextUnit(18f, TextUnitType.Sp)
            // 文字字体
            fontFamily = FontFamily.SansSerif,
            // 子间距
//        letterSpacing = 5.sp,
            // 装饰
            textDecoration = TextDecoration.combine(listOf(TextDecoration.LineThrough, TextDecoration.Underline)),
            // 设置斩首行数
            maxLines = 1,
            // 展示不全，文字展示规则
            overflow = TextOverflow.Ellipsis,
            // 文字对齐规则
            textAlign = TextAlign.Center,
//        style = 通用的样式可以用这个封装
        )
    }

    val customBuildAnnotationString = buildAnnotatedString {
        append("我学会了")

        pushStringAnnotation("zq", "zhangqi")
        withStyle(
            style = SpanStyle(
                color = Color.Red, textDecoration = TextDecoration.Underline, fontSize = 18f.sp
            )
        ) {
            append(" compose")
        }
        pop()


        pushStringAnnotation("dq", "dashignqi")
        withStyle(
            style = SpanStyle(
                color = Color.Red, textDecoration = TextDecoration.Underline, fontSize = 18f.sp
            )
        ) {
            append("嘿嘿哦呵呵呵呵呵")
        }
        pop()


        append("hello World")
    }


    // 点击方法
    ClickableText(text = customBuildAnnotationString, onClick = { offset ->
        customBuildAnnotationString.getStringAnnotations("zq", offset, offset).firstOrNull()?.let {
            Log.d("DQCompose", "你点击了我 ---> ${it.item}")
        }
        customBuildAnnotationString.getStringAnnotations("dq", offset, offset).firstOrNull()?.let {
            Log.d("DQCompose", "你点击了我 ---> ${it.item}")
        }

    })
}

@Preview(
    showBackground = true, widthDp = 100
)
@Composable
fun TextSamplePreview() {
    TextSample()

}
