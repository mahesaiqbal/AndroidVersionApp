package com.mahesaiqbal.androidversionapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();
    private TextView titleDetail, versionDetail, descriptionDetail;
    private CircleImageView photoDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        titleDetail = (TextView) findViewById(R.id.title_detail);
        versionDetail = (TextView) findViewById(R.id.version_detail);
        descriptionDetail = (TextView) findViewById(R.id.description_detail);
        photoDetail = (CircleImageView) findViewById(R.id.photo_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detail");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        Intent detailActivity = getIntent();
        String title = detailActivity.getStringExtra("Name");
        String version = detailActivity.getStringExtra("Version");
        String photo = detailActivity.getStringExtra("Photo");
        String description = detailActivity.getStringExtra("Description");

        titleDetail.setText(title);
        versionDetail.setText(version);
        descriptionDetail.setText(description);

        Glide.with(getApplicationContext())
                .load(photo)
                .into(photoDetail);

    }

}
