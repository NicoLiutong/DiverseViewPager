package com.example.viewpagertest.diverseviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 刘通 on 2017/8/24.
 */

public class RotateDownPageTransformer implements ViewPager.PageTransformer {

    private static final float ROT_MAX = 20.0f;
    private float mRot;



    public void transformPage(View view, float position)
    {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1)
        {
            view.setRotation(0);

        } else if (position <= 1)
        {
            if (position < 0)
            {

                mRot = (ROT_MAX * position);
                view.setPivotX(pageWidth * 0.5f);
                view.setPivotY( pageHeight);
                view.setRotation(mRot);
            } else
            {

                mRot = (ROT_MAX * position);
                view.setPivotX(pageWidth * 0.5f);
                view.setPivotY(pageHeight);
                view.setRotation(mRot);
            }

        } else
        {
            view.setRotation(0);
        }
    }

}
