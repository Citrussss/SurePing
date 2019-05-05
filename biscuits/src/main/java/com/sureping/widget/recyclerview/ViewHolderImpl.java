package com.sureping.widget.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author sureping
 * @create 19-5-2.
 */
class ViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding dataBinding;
    public ViewHolder(ViewDataBinding dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
    }

//    public void setVariable(E e){
//        e.inflate(null,dataBinding);
//    }
}
