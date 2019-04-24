package com.study.zyc.recyclestudy;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ManageJSONImpl {
    public void getJson(String urls, final HttpStatus callback){
        Log.i("ManageJSONImpl", "GetJson");
        String url = "http://www.weather.com.cn/data/sk/101250401.html";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("!", "onFailure: ");
                callback.failure();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();
                if(json.startsWith("\ufeff")){
                    json = json.substring(1);
                    Log.i("JSON","JSONString is '/ufeff'");
                }
                Log.i("json",""+json);

                callback.success( JSONSET(json));
            }
        });
    }

    private Map JSONSET(String json) {
        Map<String,Object> map = new HashMap<>();
        Log.i("ManageJSONImpl", "ReadJson");
        try {
            JSONObject weatherinfo = new JSONObject(json);
            JSONObject weather = weatherinfo.getJSONObject("weatherinfo");
            Log.i("ManageJSONImpl","weather"+weather);
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
//
//    @Override
//    public void success(Map<String, Object> datas) {
//        Log.i("HTTP","成功了");
//    }
//
//    @Override
//    public void failure() {
//        Log.i("HTTP","失败了");
//    }
}
