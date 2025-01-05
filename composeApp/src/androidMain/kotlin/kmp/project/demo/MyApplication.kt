package kmp.project.demo

import android.app.Application
import kmp.project.demo.db.initKoin
import kmp.project.demo.di.platformModule
import org.koin.android.ext.koin.androidContext

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MyApplication)
        }
    }
}