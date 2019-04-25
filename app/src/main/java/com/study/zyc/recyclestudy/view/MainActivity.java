package com.study.zyc.recyclestudy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.study.zyc.recyclestudy.R;
import com.study.zyc.recyclestudy.RecyclerAdapter01;
import com.study.zyc.recyclestudy.pesenter.IPresenterImpl;

import java.util.ArrayList;
import java.util.Map;



public class MainActivity extends AppCompatActivity implements IUpdataViews {
    private RecyclerView recyclerView01;
    private RecyclerAdapter01 adapter01;
    private ArrayList<String> data=new ArrayList<>();
    private IPresenterImpl iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        data.add("纵向布局");
        data.add("横向布局");
        data.add("网格布局");
        initRecyclerView(data);
    }

    private void initRecyclerView(ArrayList<String> data) {
        //初始化
        adapter01=new RecyclerAdapter01(data);
        recyclerView01.setAdapter(adapter01);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView01.setLayoutManager(manager);
    }
    private void initViews() {
        //实例化
        recyclerView01 = findViewById(R.id.recycler_view_01);
    }

    @Override
    public void upDataRecyclerView(Map<String, Object> datas) {
        //网络获取数据添加
    }

    @Override
    public void onClickThis() {
        //点击事件
    }

    @Override
    public void onLongClik() {

    }

    @Override
    public void onUpRefresh() {

    }

    @Override
    public void onBottomRefresh() {

    }

    @Override
    public void onAddData() {

    }

    @Override
    public void setT() {
//        iPresenter.setT();
    }

}
