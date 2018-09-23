package com.example.konye.lingo.ui.activities.auth.di;

import com.example.konye.lingo.ui.activities.auth.AuthActivity;
import com.example.konye.lingo.ui.activities.auth.AuthenticateActivity;

import dagger.Subcomponent;

@AuthScope
@Subcomponent(modules = {AuthActivityContextModule.class})
public interface AuthActivityComponent {

    void inject(AuthActivity activity);
    void inject(AuthenticateActivity activity);
}
