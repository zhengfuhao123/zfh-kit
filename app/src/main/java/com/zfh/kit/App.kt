package com.zfh.kit

import android.app.Application
import com.zfh.common_utils.ActivityUtil
import com.zfh.common_utils.ZUtils

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        ZUtils.init(this)
        registerActivityLifecycleCallbacks(ActivityUtil.activityLifecycleCallbacks)
    }


}