package com.example.viewpagertest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.viewpagertest.diverseviewpager.MyPageAdapter;
import com.example.viewpagertest.diverseviewpager.ShallowPageTransformer;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private MyPageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        pageAdapter = new MyPageAdapter(R.layout.card_item, getApplicationContext()) {
            @Override
            public void convert(Object data, View view) {
                ImageView imageView =(ImageView) view.findViewById(R.id.imageview);
                Glide.with(getApplicationContext()).load(data).into(imageView);
            }
        };
        initData();
        viewPager.setAdapter(pageAdapter);
        viewPager.setPageTransformer(true,new ShallowPageTransformer());
        Log.d("pagesss",viewPager.getCurrentItem() + "");
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("page",position + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pageAdapter.addData(R.drawable.ic_1);
        pageAdapter.notifyDataSetChanged();

    }

    private void initData(){

        pageAdapter.addData(R.drawable.ic_1);
        pageAdapter.addData(R.drawable.ic_2);
        pageAdapter.addData(R.drawable.ic_3);
        pageAdapter.addData(R.drawable.ic_4);
        pageAdapter.addData(R.drawable.ic_5);
        pageAdapter.addData(R.drawable.ic_6);
        pageAdapter.addData(R.drawable.ic_7);
        pageAdapter.addData(R.drawable.ic_8);

    }
}
