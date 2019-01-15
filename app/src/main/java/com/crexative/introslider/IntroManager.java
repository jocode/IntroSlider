package com.crexative.introslider;

import android.content.Context;
import android.content.SharedPreferences;

public class IntroManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public IntroManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("introslider", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setFirst(boolean isFirst){
        editor.putBoolean("check", isFirst);
        editor.commit();
    }

    public boolean check(){
        return sharedPreferences.getBoolean("check", true);
    }

}
