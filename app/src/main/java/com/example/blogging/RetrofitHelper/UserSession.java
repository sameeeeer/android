package com.example.blogging.RetrofitHelper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.blogging.Model.Usermodel;
import com.example.blogging.R;
import com.example.blogging.Responseapi.UserResponse;
import com.google.gson.Gson;

public class UserSession {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN";
    private static final String AUTH_USER = "LOGGED_IN_USER";
    public static  String tokens = "";

    public UserSession(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.user_session), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void startSession(Usermodel user) {
        UserResponse userResponse=new UserResponse();

        String userJson = new Gson().toJson(user);
        tokens=userResponse.getToken();

        editor.putBoolean(IS_USER_LOGGED_IN, true);
        editor.putString(AUTH_USER, userJson);
        editor.putString("token",tokens);
        editor.commit();
    }

    public boolean isActive() {
        return sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false);
    }

    public Usermodel getUser() {

        String userJson = sharedPreferences.getString(AUTH_USER, "");
        Usermodel user = new Gson().fromJson(userJson, Usermodel.class);

        return user;
    }

    public void endSession() {

        editor.putBoolean(IS_USER_LOGGED_IN, false);
        editor.remove(AUTH_USER);
        editor.commit();
    }
}
