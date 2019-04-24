package com.study.zyc.recyclestudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView01;
    private ManageJSONImpl manageJSON = new ManageJSONImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        userRecyclerView01(getData());
        getData();
        okHttp();
    }
    //"{\"weatherinfo\":{\"city\":\"衡阳\",\"cityid\":\"101250401\",\"temp\":\"22.6\",\"WD\":\"东北风\",\"WS\":\"小于3级\",\"SD\":\"90%\",\"AP\":\"991.7hPa\",\"njd\":\"暂无实况\",\"WSE\":\"<3\",\"time\":\"17:00\",\"sm\":\"2.9\",\"isRadar\":\"0\",\"Radar\":\"\"}}"
    private ArrayList<String> getData()  {
        ArrayList<String> data= new ArrayList<>();
        data.add("1111111");
        data.add("2222222");
        data.add("3333333");

        return data;
    }
    private void okHttp(){
        Log.i("manageJSON","datas");
        manageJSON.getJson("123", new HttpStatus() {
            @Override
            public void success(Map<String, Object> datas) {
                Log.i("manageJSON","datas"+ datas.get("city"));
                Log.i("manageJSON","datas"+ datas.get("cityid"));
                Log.i("manageJSON","datas"+ datas.get("temp"));
            }

            @Override
            public void failure() {

            }
        });
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
