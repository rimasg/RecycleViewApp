package com.sid.recycleviewapp;

import android.view.View;

import com.sid.recycleviewapp.dummy.EmptyContent.DummyItem;

/**
 * Created by Okis on 2016.09.17 @ 13:26.
 */

public interface ClickHandler {
    void onClick(DummyItem data);

    boolean onLongClick(View v);
}
