package com.jj.sureping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.jj.sureping.drag.DragActivity;
import com.jj.sureping.load.LoadingActivity;
import com.jj.sureping.slide.SlidingActivity;
import com.sureping.biscuits.dialog.IosListPopWindowBuilder;
import com.sureping.biscuits.dialog.MyAlertDialogFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ListPopupWindow;

/**
 * @author sureping
 * @create 19-4-11.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent =null;
        switch (view.getId()) {
            case R.id.slide:
                intent = new Intent(this, SlidingActivity.class);
                break;
            case R.id.load:
                intent = new Intent(this, LoadingActivity.class);
                break;
            case R.id.drag:
                intent = new Intent(this, DragActivity.class);
                break;
            case R.id.dialog:
                PopupWindow popupWindow = IosListPopWindowBuilder.build(this);

                break;

        }
        if (intent !=null)
        startActivity(intent);
    }
}
