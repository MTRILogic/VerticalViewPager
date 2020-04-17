package com.mtrilogic.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class VerticalViewPager extends ViewPager {

    public VerticalViewPager(@NonNull Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event){
        boolean intercept = super.onInterceptTouchEvent(getExChangeXY(event));
        getExChangeXY(event);
        return intercept;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        performClick();
        return super.onTouchEvent(getExChangeXY(event));
    }

    private void init(){
        setPageTransformer(true, new VerticalPage());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private MotionEvent getExChangeXY(MotionEvent event){
        float width = getWidth();
        float height = getHeight();
        float x = (event.getY() / height) * width;
        float y = (event.getX() / width) * height;
        event.setLocation(x, y);
        return event;
    }

    private static class VerticalPage implements ViewPager.PageTransformer{
        @Override
        public void transformPage(@NonNull View view, float position){
            if(position < -1 || position > 1){
                view.setAlpha(0);
            }else{
                view.setAlpha(1);
                view.setTranslationX(view.getWidth() * -position);
                view.setTranslationY(view.getHeight() * position);
            }
        }
    }
}
