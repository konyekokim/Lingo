package com.mahadum360.mahadum.utils;

/**
 * Created by KONYE on 5/10/2017.
 */

public class UserInformation {
    private String firstName, surname, username, email, password;
    int age;

    public UserInformation(String username, String password){
        this.username = username;
        this.password = password;
    }
    public UserInformation(String firstName,String surname, String username, String email,
                           String password){
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String setFirstName(String firstName){
        return firstName;
    }
    public String setSurname(String surname){
        return surname;
    }
    public String setUsername(String username){
        return username;
    }
    public String setEmail(String email){
        return email;
    }
    public String setPassword(String password){
        return password;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getSurname(){
        return surname;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
