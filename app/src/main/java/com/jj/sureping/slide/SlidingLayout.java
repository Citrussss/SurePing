package com.jj.sureping.slide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.jj.sureping.R;

/**
 * @author sureping
 * @create 19-4-10.
 */
public class SlidingLayout extends FrameLayout {
    public SlidingLayout(@androidx.annotation.NonNull Context context) {
        super(context);
    }

    public SlidingLayout(@androidx.annotation.NonNull Context context, @androidx.annotation.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int count = getChildCount();
        int sx,sy;
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            final int width = child.getMeasuredWidth();
            final int height = child.getMeasuredHeight();
            if (i==0){
                sx = left ;
                sy = top;
            }else{
                sx = left - (right - left);
                sy = top;
            }
            child.layout(sx, sy, sx + width, sy + height);
            child.setTag(R.id.dx,child.getX());
        }
    }
    private float dx = 0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getChildCount()<2) return super.onTouchEvent(event);
        else {
            final int action =event.getAction();
            final View child = getChildAt(1);
            switch (action){
                case MotionEvent.ACTION_DOWN:
                    dx = child.getX();
                    return true;
                case MotionEvent.ACTION_MOVE:
                    child.setX(event.getX()+dx);
                    return true;
                case MotionEvent.ACTION_UP:
                    if (event.getX()>getWidth()/2){
                        back(getChildAt(0));
                        top(child);
                    }else {
                     child.setX(dx);
                    }
                    return true;
                default:return super.onTouchEvent(event);
            }
        }
    }

    public void top(View child) {
        Float tag = (Float) child.getTag(R.id.dx);
        child.setX(tag!=null?tag:0);
        removeView(child);
        addView(child,0);
        requestLayout();
    }
    public void back(View child){
        Float tag = (Float) child.getTag(R.id.dx);
        child.setX(tag!=null?tag:0);
        removeView(child);
        addView(child);
        requestLayout();
    }
}
