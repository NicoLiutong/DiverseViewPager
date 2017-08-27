package com.example.viewpagertest.diverseviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 刘通 on 2017/8/24.
 */

public class CardPageTransformer implements ViewPager.PageTransformer {

    private static final float SCALE = 0.75f;
    private static final float GAP_WIDTH_DENOMINATOR = 6f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();


        if (position < -1) { // [-Infinity,-1)
            page.setTranslationX(pageWidth / GAP_WIDTH_DENOMINATOR);
            page.setScaleX(SCALE);
            page.setScaleY(SCALE);

        } else if (position <= 0) { // [-1,0]
            page.setTranslationX((pageWidth / GAP_WIDTH_DENOMINATOR) * Math.abs(position));
            page.setScaleX(SCALE + (1 + position) * 0.05f);
            page.setScaleY(SCALE + (1 + position) * 0.05f);

        } else if (position <= 1) { // (0,1]
            page.setTranslationX((pageWidth / GAP_WIDTH_DENOMINATOR) * -position);
            page.setScaleX(SCALE + (1 - position) * 0.05f);
            page.setScaleY(SCALE + (1 - position) * 0.05f);

        } else {
            page.setTranslationX(- (pageWidth / GAP_WIDTH_DENOMINATOR));
            page.setScaleX(SCALE);
            page.setScaleY(SCALE);
        }
    }
}
