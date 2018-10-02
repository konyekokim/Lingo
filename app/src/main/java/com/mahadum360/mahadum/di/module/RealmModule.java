package com.mahadum360.mahadum.di.module;


import com.mahadum360.mahadum.data.RealmService;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class RealmModule {
    @Provides
    Realm providesRealm(){
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        return Realm.getInstance(config);
    }

    @Provides
    RealmService providesRealmService(final Realm realm){
        return new RealmService(realm);
    }
}
