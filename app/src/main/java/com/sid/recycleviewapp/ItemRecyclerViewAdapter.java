package com.sid.recycleviewapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.sid.recycleviewapp.ItemFragment.OnListFragmentInteractionListener;
import com.sid.recycleviewapp.dummy.EmptyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public ItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ViewHolder viewHolder = ViewHolder.create(parent, R.layout.fragment_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DummyItem item = mValues.get(position);
        holder.binding.setVariable(com.sid.recycleviewapp.BR.data, item);
        final View contentView = holder.itemView.findViewById(R.id.content);
        final View viewById = holder.itemView.findViewById(R.id.list_item);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(item, contentView);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
