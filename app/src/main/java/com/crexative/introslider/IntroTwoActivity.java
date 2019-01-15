package com.crexative.introslider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroTwoActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mDotLayout;
    private Button btn_back_two, btn_next_two;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_two);

        viewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dots);
        btn_next_two = findViewById(R.id.btn_next_two);
        btn_back_two = findViewById(R.id.btn_skip_two);

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);



        addDotsIndicator(0);
        changeStatusBarColor();
        viewPager.addOnPageChangeListener(changeListener);

        btn_next_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentPage < mDots.length-1)
                    viewPager.setCurrentItem(mCurrentPage+1);
                else {
                    startActivity(new Intent(IntroTwoActivity.this, HomeActivity.class));
                    finish();
                }
            }
        });

        btn_back_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentPage>0)
                    viewPager.setCurrentItem(mCurrentPage-1);

            }
        });
    }

    private void changeStatusBarColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View
                    .SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void  addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(android.R.color.white));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if (mCurrentPage == 0){
                btn_next_two.setEnabled(true);
                btn_back_two.setEnabled(false);

                btn_back_two.setVisibility(View.INVISIBLE);
                btn_next_two.setText("NEXT");
                btn_back_two.setText("");

            } else if (mCurrentPage == mDots.length-1){
                btn_next_two.setEnabled(true);
                btn_back_two.setEnabled(true);

                btn_back_two.setVisibility(View.VISIBLE);
                btn_next_two.setText("FINISH");
                btn_back_two.setText("BACK");

            } else {
                btn_next_two.setEnabled(true);
                btn_back_two.setEnabled(true);

                btn_back_two.setVisibility(View.VISIBLE);
                btn_next_two.setText("NEXT  ");
                btn_back_two.setText("BACK");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
