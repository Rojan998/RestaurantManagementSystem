package com.example.mainbinamra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;

import java.util.ArrayList;

public class food extends AppCompatActivity {


    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    // From youtube https://www.youtube.com/watch?v=oq_xGMN0mRE
    // Channel Name: Android WorldClub

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, getMyList());


        mRecyclerView.setAdapter(myAdapter);


    }



    private ArrayList<model> getMyList(){

        ArrayList<model> models =  new ArrayList<>();

        model m = new model();
        m.setTitle("VEG MOMO");
        m.setDescription("This is  VEG MOMO");
        m.setImg(R.drawable.vegmomo);
        models.add(m);


        m = new model();
        m.setTitle("YOMORI");
        m.setDescription("This is YOMORI");
        m.setImg(R.drawable.yomori);
        models.add(m);


        m = new model();
        m.setTitle("PANI PURI");
        m.setDescription("This is PANI PURI");
        m.setImg(R.drawable.panipuri);
        models.add(m);

        return models;

    }
}
