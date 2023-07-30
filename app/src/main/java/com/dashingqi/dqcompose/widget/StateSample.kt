package com.dashingqi.dqcompose.widget

/**
 * @desc : State Sample
 * @author : zhangqi
 * @time : 2023/7/30 10:44
 */
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

@Composable
fun StateSample() {
//    val count = remember {
//        mutableStateOf(1)
//    }
    var count by remember {
        mutableStateOf(1)
    }
    Text(text = "今天叫了${count}个小姐姐", modifier = Modifier
        .padding(10f.dp)
        .clickable {
            count++
        })
}

@Composable
fun StateWithLiveDataSample(myViewModel: MyViewModel) {
    val uiState = myViewModel.uiState
    Button(onClick = {
        myViewModel.changeUiState()
    }) {
        Text(text = uiState)
    }

}

@Preview
@Composable
fun StateSamplePreview() {
    StateSample()
}


class MyViewModel : ViewModel() {

    private val _myData = MutableLiveData<String>()
    val myData: LiveData<String> = _myData

    var uiState by mutableStateOf("zhangqi")
        private set

    fun changeUiState() {
        uiState = "dashingqi"
    }

    fun updateData(newData: String) {
        _myData.value = newData
    }
}

