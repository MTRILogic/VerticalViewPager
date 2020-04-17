package com.mtrilogic.adapters;

import androidx.viewpager.widget.ViewPager;

public abstract class PageChangeAdapter implements ViewPager.OnPageChangeListener {

    protected PageChangeAdapter(){
        onPageSelected(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
