package com.moselin.demo.mvp.view;

import android.util.Log;

import com.moselin.demo.activity.MainActivity;
import com.moselin.demo.mvp.model.WechatEntity;
import com.moselin.moslmvp.mvp.view.IMPLBaseView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/29.
 */
public class WechatView extends IMPLBaseView<WechatEntity>
{


    private final MainActivity activity;

    public WechatView(MainActivity mainActivity)
    {
        this.activity = mainActivity;
    }

    @Override
    public String getPath()
    {
        return "weixin/query";
    }

    @Override
    public Map<String, Object> getParameters()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("pno", 1);
        map.put("ps", 20);
        map.put("key", "adbabe9d1fec9d2a03e318d51e724cdc");
        return map;
    }

    @Override
    public void onError(String msg)
    {
        Log.v("Tag",msg);
    }

    @Override
    public void onCompleted(WechatEntity entity)
    {
        activity.refreshUi(entity);
    }
}