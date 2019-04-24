package com.study.zyc.recyclestudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        userRecyclerView01();
        getData();
    }

    private void getData() {

    }

    private void userRecyclerView01() {
         ArrayList<String> data= new ArrayList<>();
        data.add("xxxxxxxxx");
        data.add("xxxxxxxxx12");
        data.add("xxxxxxx123xx");
        data.add("xxxx123xxxxx");
        data.add("xxxx123xxx2313123xx");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView01.setLayoutManager(manager);
        recyclerView01.setAdapter(new RecyclerAdapter01(data));
    }

    private void initViews() {
        recyclerView01 = findViewById(R.id.recycler_view_01);
    }
}
