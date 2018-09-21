package com.example.konye.lingo.data;

import io.realm.Realm;

public class RealmService {
    private Realm realm;

    public RealmService(Realm realm){
        this.realm = realm;
    }

    public boolean isLoggedIn(){
        return false;
    }

    public void setLoggedIn(){

    }
}
