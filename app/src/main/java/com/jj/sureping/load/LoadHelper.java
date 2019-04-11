package com.jj.sureping.load;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jj.sureping.R;

import java.lang.ref.WeakReference;

import androidx.annotation.LayoutRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author sureping
 * @create 19-4-11.
 */
public class LoadHelper<CL extends Context & LifecycleOwner> implements LifecycleObserver {

    private WeakReference<CL> reference;
    private View content, loading;
    private ViewGroup rootView;

    public LoadHelper(CL cl) {
        this.reference = new WeakReference<>(cl);
        cl.getLifecycle().addObserver(this);
    }

    public void init(View content) {
        this.content = content;
        ViewGroup parent = (ViewGroup) content.getParent();
        if (rootView != parent) {
            rootView = new FrameLayout(content.getContext());
            rootView.setLayoutParams(content.getLayoutParams());
            int i = parent.indexOfChild(content);
            parent.removeViewAt(i);
            parent.addView(rootView, i);
            content.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            rootView.addView(content);
        }
    }

    public View load() {
        return inflate(R.layout.loading_wait);
    }
//    public View load() {
//        return inflate(R.layout.loading_wait);
//    }
    public View success() {
        return inflate(R.layout.loading_succese);
    }

    public View fail(CharSequence tip) {
        View inflate = inflate(R.layout.loading_fail);
        setText(inflate, tip);
        return inflate;
    }

    private void setText(View inflate, CharSequence tip) {
        View viewById = inflate.findViewById(R.id.tip);
        if (viewById instanceof TextView) {
            ((TextView) viewById).setText(tip);
            ((TextView) viewById).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public View empty() {
        return inflate(R.layout.loading_empty);
    }

    private View inflate(@LayoutRes int layoutId) {
        if (loading == null) {
            loading = LayoutInflater.from(reference.get()).inflate(layoutId, rootView, false);
            loading.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            rootView.addView(loading);
            return loading;
        } else {
            onCancel();
            return inflate(layoutId);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onCancel() {
        if (loading != null) {
            rootView.removeView(loading);
            loading = null;
        }
    }
}
