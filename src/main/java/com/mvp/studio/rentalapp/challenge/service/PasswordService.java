package com.mvp.studio.rentalapp.challenge.service;

public class PasswordService {

    private static String PASSEWORD = "Password0";

    public boolean validatePassword(String password){
        return password.equals(PASSEWORD);
    }
}
