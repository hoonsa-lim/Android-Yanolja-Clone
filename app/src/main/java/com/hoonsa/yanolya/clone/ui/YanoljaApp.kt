package com.hoonsa.yanolya.clone.ui

import android.app.Application
import android.util.Log
import com.hoonsa.yanolya.clone.BuildConfig
import timber.log.Timber
import timber.log.Timber.*


class YanoljaApp: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }
}

/** A tree which logs important information for crash reporting.  */
private class CrashReportingTree : Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

//        FakeCrashLibrary.log(priority, tag, message)
//        if (t != null) {
//            if (priority == Log.ERROR) {
//                FakeCrashLibrary.logError(t)
//            } else if (priority == Log.WARN) {
//                FakeCrashLibrary.logWarning(t)
//            }
//        }
    }
}