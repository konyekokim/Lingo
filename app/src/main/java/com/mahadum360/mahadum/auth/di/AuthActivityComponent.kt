package com.mahadum360.mahadum.auth.di

import com.mahadum360.mahadum.auth.AuthActivity

import dagger.Subcomponent

@AuthScope
@Subcomponent(modules = arrayOf(AuthActivityContextModule::class))
interface AuthActivityComponent {

    fun inject(activity: AuthActivity)
}
