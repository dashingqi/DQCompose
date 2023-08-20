package com.dashingqi.dqcompose.permision

/**
 * @desc : permission sample
 * @author : zhangqi
 * @time : 2023/8/19 17:21
 */
import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionSample() {
    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (permissionState.status) {
            PermissionStatus.Granted -> {
                // 权限同意
                Text(text = "已同意相机权限")
            }

            is PermissionStatus.Denied -> {
                // 权限拒绝
                Column {
                    // 1. 点击了拒绝权限
                    val text = if ((permissionState.status as PermissionStatus.Denied).shouldShowRationale) {
                        "相机权限已拒绝，点击按钮再次请求"
                    } else {
                        // 2.默认情况，第一次申请
                        "相机权限已被禁止"
                    }

                    Text(text = text)
                    // 申请权限 permissionState.launchPermissionRequest()
                    Button(onClick = { permissionState.launchPermissionRequest() }) {
                        Text(text = "申请权限")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionSample2() {
    val multiPermissionState =
        rememberMultiplePermissionsState(listOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO))

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        multiPermissionState.permissions.forEach { permissionState ->
            when (permissionState.permission) {
                Manifest.permission.CAMERA -> {
                    when (permissionState.status) {
                        PermissionStatus.Granted -> {
                            // 权限同意
                            Text(text = "已同意相机权限")
                        }

                        is PermissionStatus.Denied -> {
                            // 权限拒绝
                            Column {
                                // 1. 点击了拒绝权限
                                val text =
                                    if ((permissionState.status as PermissionStatus.Denied).shouldShowRationale) {
                                        "相机权限已拒绝，点击按钮再次请求"
                                    } else {
                                        // 2.默认情况，第一次申请
                                        "相机权限已被禁止"
                                    }

                                Text(text = text)
                            }
                        }
                    }

                }

                Manifest.permission.RECORD_AUDIO -> {

                    when (permissionState.status) {
                        PermissionStatus.Granted -> {
                            // 权限同意
                            Text(text = "已同意录音权限")
                        }

                        is PermissionStatus.Denied -> {
                            // 权限拒绝
                            Column {
                                // 1. 点击了拒绝权限
                                val text =
                                    if ((permissionState.status as PermissionStatus.Denied).shouldShowRationale) {
                                        "录音权限已拒绝，点击按钮再次请求"
                                    } else {
                                        // 2.默认情况，第一次申请
                                        "录音权限已被禁止"
                                    }

                                Text(text = text)
                            }
                        }
                    }

                }
            }
        }

        // 申请权限 permissionState.launchPermissionRequest()
        Button(onClick = { multiPermissionState.launchMultiplePermissionRequest() }) {
            Text(text = "申请权限")
        }

    }
}

@Composable
fun handlePermissionState() {

}

@Preview
@Composable
fun PermissionSamplePreview() {
    PermissionSample2()
}

