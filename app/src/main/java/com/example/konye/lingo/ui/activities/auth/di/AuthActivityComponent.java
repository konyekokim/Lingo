package com.example.konye.lingo.ui.activities.auth.di;

import com.example.konye.lingo.ui.activities.auth.AuthActivity;

import dagger.Subcomponent;

@AuthScope
@Subcomponent(modules = {AuthActivityContextModule.class})
public interface AuthActivityComponent {

    void inject(AuthActivity activity);
}
