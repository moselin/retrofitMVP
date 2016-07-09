package com.moselin.demo;

import android.app.Application;

import com.moselin.moslmvp.Mosl;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;


/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
//        Mosl.init(this,"http://v.juhe.cn");
        Map<String,String> header = new HashMap<>();
        header.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        header.put("Accept-Encoding", "gzip, deflate");
        header.put("Connection", "keep-alive");
        header.put("Accept", "*/*");
        Mosl.init(this,"http://119.147.33.16/dd.myapp.com/",header);
//        Mosl.init(this,"http://v.juhe.cn",header);
    }
}
