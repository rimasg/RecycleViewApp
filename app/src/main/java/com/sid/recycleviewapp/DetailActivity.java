package com.sid.recycleviewapp;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String VIEW_DETAILED_TEXT = "detail:header:text";
    private TextView detailedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailedText = (TextView) findViewById(R.id.detailed_text);

        ViewCompat.setTransitionName(detailedText, VIEW_DETAILED_TEXT);

        loadData(getIntent());
    }

    private void loadData(Intent intent) {
        final String dataString = intent.getStringExtra(VIEW_DETAILED_TEXT);
        detailedText.setText(dataString);
    }
}
