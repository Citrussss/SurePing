package com.sureping.widget.recyclerview;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

/**
 * @author sureping
 * @create 19-5-2.
 */
public interface Inflate {
    ViewDataBinding inflate(@NonNull ViewGroup parent, ViewDataBinding binding);
    int getLayoutId();
}
