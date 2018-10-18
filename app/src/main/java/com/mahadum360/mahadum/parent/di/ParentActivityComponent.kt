package com.mahadum360.mahadum.parent.di

import com.mahadum360.mahadum.parent.ParentActivity
import dagger.Subcomponent

@ParentScope
@Subcomponent(modules = arrayOf(ParentActivityContextModule::class))
interface ParentActivityComponent{

    fun inject(activity: ParentActivity)
}