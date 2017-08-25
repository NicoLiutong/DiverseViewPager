package com.example.viewpagertest.diverseviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘通 on 2017/8/8.
 */

public  abstract class MyPageAdapter<T> extends PagerAdapter {

    private List <View> viewLists;

    private List<T> dataLists;

    private Context mContext;

    private int mLayoutId;


    public MyPageAdapter(int layoutId, Context context){

        viewLists = new ArrayList<>();
        dataLists = new ArrayList<>();
        mContext = context;
        mLayoutId = layoutId;
    }

    public void addData(T data){
            viewLists.add(null);
            dataLists.add(data);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutId,container,false);
        convert(dataLists.get(position),view);
        viewLists.set(position,view);
        container.addView(view);
        return position;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
        viewLists.set(position,null);
    }

    public View getViewAt(int position) {
        return viewLists.get(position);
    }

    @Override
    public int getCount() {
        return dataLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == viewLists.get((int)Integer.parseInt(object.toString()));
    }

    public abstract void convert(T data,View view);
}

