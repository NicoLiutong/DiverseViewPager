# DiverseViewPager
  1.实现了一些简单的viewpager的切换动画，用户一行代码就可以实现丰富多样的切换<br>
  2.实现在layout布局viewpager的每一个子项，在主函数中对其更新
  
#### layout编写
  编写需要重复显示的layout，到时候就可以在主函数中通过datalist对每页进行更新。<br>
```XML
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/cardview"
    android:layout_gravity="center"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">
    <ImageView
        android:id="@+id/imageview"
        android:layout_gravity="center"
        android:scaleType="centerCrop"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</android.support.v7.widget.CardView>
```
#### 初始化ViewPager和PagerAdapter
  获取viewPager，并实现MyPageAdapter传入layout和context，实现convert根据data实现每个组件的显示。<br>
```Java
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        pageAdapter = new MyPageAdapter(R.layout.card_item, getApplicationContext()) {
            @Override
            public void convert(Object data, View view) {
                ImageView imageView =(ImageView) view.findViewById(R.id.imageview);
                Glide.with(getApplicationContext()).load(data).into(imageView);
            }
        };
```
#### 初始化数据
```Java
        pageAdapter.addData(R.drawable.ic_1);
        pageAdapter.addData(R.drawable.ic_2);
        pageAdapter.addData(R.drawable.ic_3);
        pageAdapter.addData(R.drawable.ic_4);
        pageAdapter.addData(R.drawable.ic_5);
        pageAdapter.addData(R.drawable.ic_6);
        pageAdapter.addData(R.drawable.ic_7);
        pageAdapter.addData(R.drawable.ic_8);
```
#### 给ViewPager设置PageAdapter
```Java
        viewPager.setAdapter(pageAdapter);
```
#### 设置多样的切换动画
1.方块切换
```Java
        viewPager.setPageTransformer(true,new BoxRoatePageTransformer());
```
![](https://github.com/NicoLiutong/DiverseViewPager/blob/master/Screenshots/BoxTransformerAnimation.gif)<br>
2.右层叠切换
```Java
        viewPager.setPageTransformer(true,new DepthPageTransformer());
```
![](https://github.com/NicoLiutong/DiverseViewPager/blob/master/Screenshots/DepthTransformerAnimation.gif)<br>
3.旋转切换
```Java
        viewPager.setPageTransformer(true,new RoatePageTransformer());
```
![](https://github.com/NicoLiutong/DiverseViewPager/blob/master/Screenshots/RotateTransformerAnimation.gif)<br>
4.翻转切换
```Java
        viewPager.setPageTransformer(true,new RotateDownPageTransformer());
```
![](https://github.com/NicoLiutong/DiverseViewPager/blob/master/Screenshots/RotateDownTransformerAnimation.gif)<br>
5.左层叠切换
```Java
        viewPager.setPageTransformer(true,new ShallowPageTransformer());
```
![](https://github.com/NicoLiutong/DiverseViewPager/blob/master/Screenshots/ShallowTransformerAnimation.gif)<br>
6.淡入淡出切换
```Java
        viewPager.setPageTransformer(true,new ZoomOutPageTransformer());
```
![](https://github.com/NicoLiutong/DiverseViewPager/blob/master/Screenshots/ZoomOutTransformerAnimation.gif)<br>
7.卡片切换
```Java
        viewPager.setPageTransformer(true,new CardPageTransformer());
```
![](https://github.com/NicoLiutong/DiverseViewPager/blob/master/Screenshots/CardTransformerAnimation.gif)<br>

## License

    Copyright 2017 jeanboy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
