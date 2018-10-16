package com.mahadum360.mahadum

import android.app.Activity
import android.app.Application
import android.content.Context

import com.mahadum360.mahadum.di.component.AppComponent
import com.mahadum360.mahadum.di.component.DaggerAppComponent
import com.mahadum360.mahadum.di.module.AppModule

import io.realm.Realm
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class Mahadum : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        Realm.init(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base))

    }

    companion object {

        operator fun get(activity: Activity): Mahadum {
            return activity.application as Mahadum
        }
    }

}
