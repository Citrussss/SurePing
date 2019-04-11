package com.jj.sureping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jj.sureping.load.LoadingActivity;
import com.jj.sureping.slide.SlidingActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent;
        switch (view.getId()) {
            case R.id.slide:
                intent = new Intent(this, SlidingActivity.class);
                startActivity(intent);
                break;
            case R.id.load:
                intent = new Intent(this, LoadingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
