package com.jj.sureping.load;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.animation.CycleInterpolator;

import com.jj.sureping.R;
import com.jj.sureping.load.LoadHelper;

/**
 * @author sureping
 * @create 19-4-3.
 */
public class LoadingActivity extends AppCompatActivity {
    private LoadHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        helper = new LoadHelper<>(this);
        helper.init(findViewById(R.id.content));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.load:
                ViewCompat.animate(helper.load()).rotation(360).setDuration(10000).setInterpolator(new CycleInterpolator(100)).start();
//                helper.load().animate().withLayer().rotation(360).setDuration(1000);
                break;
            case R.id.success:
                helper.success();
                break;
            case R.id.fail:
                SpannableString string = new SpannableString("点击重试");
                ClickableSpan clickableSpan = new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        helper.success();
                    }

                    @Override
                    public void updateDrawState(@NonNull TextPaint ds) {
                        super.updateDrawState(ds);
                        ds.setColor(getResources().getColor(R.color.colorPrimary));
                    }
                };
                string.setSpan(clickableSpan, 0, 4,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                helper.fail(string);
                break;
            case R.id.cancel:
                helper.onCancel();
                break;
        }
    }
}
