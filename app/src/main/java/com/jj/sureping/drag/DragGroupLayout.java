package com.jj.sureping.drag;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

/**
 * @author sureping
 * @create 19-4-15.
 */
public class DragGroupLayout extends FrameLayout {
    public DragGroupLayout(@NonNull Context context) {
        super(context);
    }

    public DragGroupLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragGroupLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ViewDragHelper viewDragHelper;
    private DragCallBack dragCallBack;
    private Point mAutoBackOriginPos = new Point();

    public ViewDragHelper getViewDragHelper() {
        if (viewDragHelper == null)
            viewDragHelper = ViewDragHelper.create(this, 1, dragCallBack = new DragCallBack());
        return viewDragHelper;
    }

    private class DragCallBack extends ViewDragHelper.Callback {
        private ViewDragHelper dragHelper;

        /**
         * 进行捕获拦截，那些View可以进行drag操作
         *
         * @param child
         * @param pointerId
         * @return 直接返回true，拦截所有的VIEW
         */
        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            mAutoBackOriginPos.x = child.getLeft();
            mAutoBackOriginPos.y = child.getTop();
            return true;
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            Log.d("DragLayout", "clampViewPositionHorizontal " + left + "," + dx);
            final int leftBound = getPaddingLeft();
            final int rightBound = getWidth() - child.getWidth();
            final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
            return newLeft;
        }

        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            return (int) child.getY();
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            getViewDragHelper().settleCapturedViewAt(200, 200);
            postInvalidate();
        }

        /**
         * @param edgeFlags
         * @param pointerId
         */
        @Override
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            getViewDragHelper().captureChildView(getChildAt(0), pointerId);
        }

        @Override
        public void onEdgeTouched(int edgeFlags, int pointerId) {
            super.onEdgeTouched(edgeFlags, pointerId);
        }
    }

    /**
     * 事件分发
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return getViewDragHelper().shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        getViewDragHelper().processTouchEvent(ev);
        return true;
    }


}
