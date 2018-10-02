package com.mahadum360.mahadum.data;

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
