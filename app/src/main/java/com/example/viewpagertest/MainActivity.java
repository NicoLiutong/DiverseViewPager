package com.example.viewpagertest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.viewpagertest.diverseviewpager.BoxRoatePageTransformer;
import com.example.viewpagertest.diverseviewpager.CardPageTransformer;
import com.example.viewpagertest.diverseviewpager.DepthPageTransformer;
import com.example.viewpagertest.diverseviewpager.MyPageAdapter;
import com.example.viewpagertest.diverseviewpager.RoatePageTransformer;
import com.example.viewpagertest.diverseviewpager.RotateDownPageTransformer;
import com.example.viewpagertest.diverseviewpager.ShallowPageTransformer;
import com.example.viewpagertest.diverseviewpager.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewPager;

    private MyPageAdapter pageAdapter;

    private Button boxRoate,depth,roate,roateDown,shallow,zoomOut,card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        boxRoate = (Button) findViewById(R.id.box_roate);
        boxRoate.setOnClickListener(this);
        depth = (Button) findViewById(R.id.depth);
        depth.setOnClickListener(this);
        roate = (Button) findViewById(R.id.roate);
        roate.setOnClickListener(this);
        roateDown = (Button) findViewById(R.id.roate_down);
        roateDown.setOnClickListener(this);
        shallow = (Button) findViewById(R.id.shallow);
        shallow.setOnClickListener(this);
        zoomOut = (Button) findViewById(R.id.zoom_out);
        zoomOut.setOnClickListener(this);
        card = (Button) findViewById(R.id.card);
        card.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.box_roate :
                viewPager.setPageTransformer(true,new BoxRoatePageTransformer());
                break;
            case R.id.depth :
                viewPager.setPageTransformer(true,new DepthPageTransformer());
                break;
            case R.id.roate :
                viewPager.setPageTransformer(true,new RoatePageTransformer());
                break;
            case R.id.roate_down :
                viewPager.setPageTransformer(true,new RotateDownPageTransformer());
                break;
            case R.id.shallow :
                viewPager.setPageTransformer(true,new ShallowPageTransformer());
                break;
            case R.id.zoom_out :
                viewPager.setPageTransformer(true,new ZoomOutPageTransformer());
                break;
            case R.id.card :
                viewPager.setPageTransformer(true,new CardPageTransformer());
                break;
        }
    }
}
