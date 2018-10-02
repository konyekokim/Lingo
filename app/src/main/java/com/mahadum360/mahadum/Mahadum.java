package com.mahadum360.mahadum;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.mahadum360.mahadum.di.component.AppComponent;
import com.mahadum360.mahadum.di.component.DaggerAppComponent;
import com.mahadum360.mahadum.di.module.AppModule;

import io.realm.Realm;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Mahadum extends Application {

    AppComponent component;

    public static Mahadum get(Activity activity) {
        return (Mahadum) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        Realm.init(this);
    }

    public AppComponent getAppComponent() {
        return component;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));

    }

}
