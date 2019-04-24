package com.study.zyc.recyclestudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView01;
    private ManageJSONImpl manageJSON = new ManageJSONImpl();
    int [] cityIds= {101010100,101010300,101010400,101010600,101010700,101010800};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        userRecyclerView01(getData());
    }
    private ArrayList<String> getData(){
        final ArrayList<String> data=new ArrayList<>();
        Log.i("manageJSON","datas");
        manageJSON.getJson(cityIds, new HttpStatus() {
            @Override
            public void success(Map<String, Object> datas) {
                data.add(datas.get("city")+"");
            }
            @Override
            public void failure() {

            }
        });
        return data;
    }
    private void userRecyclerView01(ArrayList<String> data) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView01.setLayoutManager(manager);
        recyclerView01.setAdapter(new RecyclerAdapter01(data));
    }
    private void initViews() {
        recyclerView01 = findViewById(R.id.recycler_view_01);
    }

}
