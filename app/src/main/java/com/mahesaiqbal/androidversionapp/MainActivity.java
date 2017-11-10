package com.mahesaiqbal.androidversionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mahesaiqbal.androidversionapp.adapter.AndroidAdapter;
import com.mahesaiqbal.androidversionapp.data.AndroidData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAndroid;
    private ArrayList<Android> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroid = (RecyclerView) findViewById(R.id.rv_android);
        rvAndroid.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(AndroidData.getListData());

        getSupportActionBar().setTitle("Android Version App");

        showRecyclerList();



    }

    private void showRecyclerList() {

        rvAndroid.setLayoutManager(new LinearLayoutManager(this));
        AndroidAdapter androidAdapter = new AndroidAdapter(this);
        androidAdapter.setListAndroid(list);
        rvAndroid.setAdapter(androidAdapter);

        ItemClickSupport.addTo(rvAndroid).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {

            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                showSelectedAndroid(list.get(position));

            }

        });

    }

    private void showSelectedAndroid(Android android){

        Toast.makeText(this, "You choose "+android.getName(), Toast.LENGTH_SHORT).show();

    }

}

