package com.sid.recycleviewapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.radius;

public class DetailActivity extends AppCompatActivity {
    public static final String VIEW_DETAILED_TEXT = "detail:header:text";
    private TextView detailedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailedText = (TextView) findViewById(R.id.detailed_text);

        final ImageView detailedImageView = (ImageView) findViewById(R.id.detailed_image);
        detailedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final int cx = detailedImageView.getWidth() / 2;
                final int cy = detailedImageView.getHeight() / 2;
                final float radius = (float) Math.hypot(cx, cy);
                createCircularReveal(v, cx, cy);
            }
        });

        ViewCompat.setTransitionName(detailedText, VIEW_DETAILED_TEXT);

        loadData(getIntent());
    }

    private void loadData(Intent intent) {
        final String dataString = intent.getStringExtra(VIEW_DETAILED_TEXT);
        detailedText.setText(dataString);
    }

    private void createCircularReveal(final View v, int x, int y) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final Animator anim = ViewAnimationUtils.createCircularReveal(v, x, y, radius, 0);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    v.setVisibility(View.INVISIBLE);
                }
            });
            anim.start();
        }
    }
}
