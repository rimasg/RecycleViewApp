package com.sid.recycleviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sid.recycleviewapp.dummy.EmptyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ItemFragment itemFragment = ItemFragment.newInstance(0);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, itemFragment, ItemFragment.TAG)
                .commit();
    }

    @Override
    public void onListFragmentInteraction(EmptyContent.DummyItem item, View view) {
        final Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.VIEW_DETAILED_TEXT, item.content);

        final ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<View, String>(view, DetailActivity.VIEW_DETAILED_TEXT));
        ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
    }
}
