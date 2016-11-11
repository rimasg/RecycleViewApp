package com.sid.recycleviewapp;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class ViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public T binding;

    public ViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public static <T extends ViewDataBinding> ViewHolder<T> create(ViewGroup parent, @LayoutRes int layoutId) {
        T binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
        return new ViewHolder<>(binding);
    }
}
