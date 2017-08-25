package com.example.viewpagertest.diverseviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 刘通 on 2017/8/24.
 */

public class ShallowPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1 + position);
            view.setTranslationX(pageWidth * -position);
            float scaleFactor = 1 - (1 - MIN_SCALE) * (Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else if (position <= 1) { // (0,1]
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);

        } else {
            view.setAlpha(0);
        }
    }
}
