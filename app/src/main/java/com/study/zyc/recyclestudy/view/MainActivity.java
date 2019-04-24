package com.study.zyc.recyclestudy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.study.zyc.recyclestudy.R;
import com.study.zyc.recyclestudy.RecyclerAdapter01;
import com.study.zyc.recyclestudy.pesenter.JSONDataManage;
import com.study.zyc.recyclestudy.pesenter.UpdataViews;

import java.util.ArrayList;
import java.util.Map;



public class MainActivity extends AppCompatActivity implements UpdataViews {
    private RecyclerView recyclerView01;
    private JSONDataManage presenterJson ;
    int [] cityIds= {101010100,101010300,101010400,101010600,101010700,101010800};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenterJson.request(cityIds);
        initViews();
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

    @Override
    public void upDataRecyclerView(Map<String, Object> datas) {
        final ArrayList<String> data=new ArrayList<>();
        data.add(datas.get("city")+"");
        userRecyclerView01(data);
    }
}
