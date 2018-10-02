package com.mahadum360.mahadum.ui.activities.auth.di;

import com.mahadum360.mahadum.ui.activities.auth.AuthActivity;

import dagger.Subcomponent;

@AuthScope
@Subcomponent(modules = {AuthActivityContextModule.class})
public interface AuthActivityComponent {

    void inject(AuthActivity activity);
}
