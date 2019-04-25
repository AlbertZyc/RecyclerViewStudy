//package com.study.zyc.recyclestudy.model;
//
//import android.util.Log;
//import com.study.zyc.recyclestudy.pesenter.HttpStatus;
//import java.io.IOException;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//public class ManageJSONModel {
//    private HttpStatus result;
//
//    public ManageJSONModel(HttpStatus result) {
//        this.result = result;
//    }
//
//    public void getJson(int[] cityId){
//        for(int i : cityId){
//            String url = "http://www.weather.com.cn/data/sk/"+i+".html";
//            OkHttpClient okHttpClient = new OkHttpClient();
//            final Request request = new Request.Builder()
//                    .url(url)
//                    .get()
//                    .build();
//            Call call = okHttpClient.newCall(request);
//            call.enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    result.failure();
//                }
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    String json = response.body().string();
//                    if(json.startsWith("\ufeff")){
//                        json = json.substring(1);
//                    }
//                    result.success(json);
//                }
//            });
//        }
//    }
//
//}
