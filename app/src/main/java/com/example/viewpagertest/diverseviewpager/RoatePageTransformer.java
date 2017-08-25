package com.example.viewpagertest.diverseviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 刘通 on 2017/8/24.
 */

public class RoatePageTransformer implements ViewPager.PageTransformer {
    public void transformPage(View view, float position)
    {
        int pageWidth = view.getWidth();

        if (position < -1)
        { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 0)
        {
            view.setAlpha(1+position);
            view.setScaleX(1 + position);
            view.setTranslationX(pageWidth * (-position));

        } else if(position <= 1)
        {
            view.setAlpha(1-position);
            view.setScaleX(1 - position);
            view.setTranslationX(-(pageWidth * position));
        } else {
            view.setAlpha(0);
        }
    }
}
