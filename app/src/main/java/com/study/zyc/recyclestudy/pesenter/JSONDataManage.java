package com.study.zyc.recyclestudy.pesenter;

import android.util.Log;
import com.study.zyc.recyclestudy.model.ManageJSONModel;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class JSONDataManage {
    private UpdataViews updataViews;
    private ManageJSONModel jsonModel;

    public JSONDataManage(UpdataViews updataViews) {
        this.updataViews = updataViews;
        jsonModel = new ManageJSONModel(new HttpStatus() {
            @Override
            public void success(String datas) {
                JSONDataManage.this.updataViews.upDataRecyclerView(JSONSET(datas));
            }

            @Override
            public void failure() {
//                JSONDataManage.this.updataViews.upDataRecyclerView();
            }
        });
    }
    public void detachView() {
        updataViews = null;
    }

    public void request(int[] id) {
        jsonModel.getJson(id);
    }
    private Map JSONSET(String json) {
        Map<String,Object> map = new HashMap<>();
        try {
            JSONObject weatherinfo = new JSONObject(json);
            JSONObject weather = weatherinfo.getJSONObject("weatherinfo");
            Log.i("ManageJSONModel","weather"+weather);
            String city = weather.getString("city");
            String cityid = weather.getString("cityid");
            String temp = weather.getString("temp");
            String WD = weather.getString("WD");
            String WS= weather.getString("WS");
            String SD= weather.getString("SD");
            String AP= weather.getString("AP");
            String njd= weather.getString("njd");
            String WSE= weather.getString("WSE");
            String time= weather.getString("time");
            String sm= weather.getString("sm");
            map.put("city",city);
            map.put("cityid",cityid);
            map.put("temp",temp);
            map.put("WD",WD);
            map.put("SD",SD);
            map.put("WS",WS);
            map.put("njd",njd);
            map.put("AP",AP);
            map.put("WSE",WSE);
            map.put("time",time);
            map.put("sm",sm);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("xx",e.toString());
        }
        return map;
    }

}
