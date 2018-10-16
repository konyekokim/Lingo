package com.mahadum360.mahadum.di.module


import com.mahadum360.mahadum.data.RealmService

import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
class RealmModule {
    @Provides
    internal fun providesRealm(): Realm {
        val config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()

        return Realm.getInstance(config)
    }

    @Provides
    internal fun providesRealmService(realm: Realm): RealmService {
        return RealmService(realm)
    }
}
