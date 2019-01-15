package com.crexative.introslider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    // Arrays
    public int[] slide_images = {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
    };

    public String[] slide_heading = {
      "EAT",
      "SLEEP",
      "CODE"
    };

    public String[] slide_description = {
            "Some one descripction for eat",
            "Eevery day we have to sleep",
            "Is a great pasion for me"
    };

    public SliderAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slide_layour, container, false);

        ImageView image_slide = view.findViewById(R.id.image_slide);
        TextView heading_slide = view.findViewById(R.id.heading);
        TextView desc_slide = view.findViewById(R.id.description);

        image_slide.setImageResource(slide_images[position]);
        heading_slide.setText(slide_heading[position]);
        desc_slide.setText(slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
