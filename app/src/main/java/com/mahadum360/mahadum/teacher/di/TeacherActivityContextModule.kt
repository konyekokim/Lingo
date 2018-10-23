package com.mahadum360.mahadum.teacher.di

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.teacher.TeacherContract
import com.mahadum360.mahadum.teacher.TeacherPresenter
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class TeacherActivityContextModule(private val view: TeacherContract.View){

    @Provides
    @TeacherScope
    internal fun providesView() : TeacherContract.View{
        return view
    }

    @Provides
    @TeacherScope
    internal fun providesPresenter(apiService: ApiService, realmService: RealmService, view: TeacherContract.View,
                                   provider: SchedulerProvider): TeacherPresenter{
        return TeacherPresenter(apiService, realmService, view, provider)
    }

}