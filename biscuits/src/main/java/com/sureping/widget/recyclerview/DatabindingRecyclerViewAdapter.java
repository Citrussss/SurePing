package com.sureping.widget.recyclerview;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sureping
 * @create 19-5-2.
 */
public class DatabindingRecyclerViewAdapter<E extends Inflate> extends RecyclerView.Adapter<ViewHolder> {
    private List<E> list = new ArrayList<>();
    private SparseArray<E> typeList = new SparseArray<>();

    @Override
    public int getItemCount() {
        return list.size();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }
    @Override
    public int getItemViewType(int position) {
        E e = list.get(position);
        int layoutId = e.getLayoutId();
        int index = typeList.indexOfKey(layoutId);
        if (index<=0)typeList.put(layoutId,e);
        return layoutId;
    }

}
