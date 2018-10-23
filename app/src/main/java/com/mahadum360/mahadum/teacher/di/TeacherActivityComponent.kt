package com.mahadum360.mahadum.teacher.di

import com.mahadum360.mahadum.teacher.TeacherActivity
import dagger.Subcomponent

@TeacherScope
@Subcomponent(modules = [TeacherActivityContextModule::class])
interface TeacherActivityComponent{

    fun inject(activity : TeacherActivity)

}