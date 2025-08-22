package com.zfh.common_utils

import android.annotation.SuppressLint
import android.os.Looper
import android.view.Gravity
import android.widget.Toast

object ToastUtil {
    private var toast: Toast? = null

    fun show(msg: String) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createToast(msg)
        } else {
            ActivityUtil.currentActivity?.runOnUiThread { createToast(msg) }
        }
    }

    /**
     * createToast
     *
     * @param msg 接收参数
     */
    @SuppressLint("ShowToast")
    private fun createToast(msg: String) {
        if (null == toast) {
            toast = Toast.makeText(ZUtils.getApp().applicationContext, msg, Toast.LENGTH_SHORT)
        } else {
            toast?.setText(msg)
        }
        toast?.show()
    }

    fun showCenter(msg: String) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createCenterToast(msg)
        } else {
            ActivityUtil.currentActivity?.runOnUiThread { createCenterToast(msg) }
        }
    }

    /**
     * createCenterToast
     *
     * @param msg 接收参数
     */
    @SuppressLint("ShowToast")
    private fun createCenterToast(msg: String) {
        if (null == toast) {
            toast = Toast.makeText(ZUtils.getApp().applicationContext, msg, Toast.LENGTH_SHORT)
        } else {
            toast?.setText(msg)
        }
        toast?.setGravity(Gravity.CENTER, 0, 0)
        toast?.show()
    }


    /**
     * 取消Toast
     * onDestroy时调用，或者onPause
     * 当前页面finish之后在下一个页面不会显示
     */
    fun cancel() {
        toast?.cancel()
    }

    /**
     * 回收Toast
     */
    fun release() {
        toast?.let {
            it.cancel()
            toast = null
        }
    }
}