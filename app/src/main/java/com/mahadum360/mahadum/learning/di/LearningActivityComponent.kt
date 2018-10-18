package com.mahadum360.mahadum.learning.di

import com.mahadum360.mahadum.learning.LearningActivity
import dagger.Subcomponent

@LearningScope
@Subcomponent(modules = [LearningActivityContextModule::class])
interface LearningActivityComponent{

    fun inject(activity: LearningActivity)

}