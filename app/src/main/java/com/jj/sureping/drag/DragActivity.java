package com.jj.sureping.drag;

import android.os.Bundle;
import android.view.ViewGroup;

import com.jj.sureping.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.ViewDragHelper;

/**
 * @author sureping
 * @create 19-4-15.
 */
public class DragActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
    }
//    public static ViewDragHelper create(ViewGroup forParent, float sensitivity, ViewDragHelper.Callback cb) {
//        final ViewDragHelper.create(forParent, cb) helper =create();
//        helper.mTouchSlop = (int)(helper.mTouchSlop * (1 / sensitivity));
//        return helper;
//    }
}
