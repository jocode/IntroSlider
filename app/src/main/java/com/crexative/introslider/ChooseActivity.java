package com.crexative.introslider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }

    public void handleIntroOne(View view) {
        startActivity(new Intent(this, IntroOneActivity.class));
    }

    public void handleIntroTwo(View view) {
        startActivity(new Intent(this, IntroTwoActivity.class));
    }
}
