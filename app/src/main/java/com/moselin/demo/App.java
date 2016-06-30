package com.moselin.demo;

import android.app.Application;

import com.moselin.moslmvp.Mosl;


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
        Mosl.init(this,"http://v.juhe.cn");
    }
}
