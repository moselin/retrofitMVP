package com.moselin.demo.mvp.view;

import android.util.Log;

import com.moselin.demo.activity.MainActivity;
import com.moselin.demo.mvp.model.WechatEntity;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/8.
 */
public class WechatViewImpl implements IWechatView
{
    private final MainActivity activity;

    public WechatViewImpl(MainActivity mainActivity)
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
    public void onError(int code,String msg)
    {
        Log.v("Tag","code:"+code+";msg:"+msg);
    }

    @Override
    public void onCompleted(WechatEntity entity)
    {
        activity.refreshUi(entity);
    }

    @Override
    public void onDownload(ResponseBody entity)
    {
        activity.refreshDownloadUi(entity);
    }

    @Override
    public void progress(final long progress, final long total, final boolean done)
    {
        if (!done)
            activity.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    activity.updateProgress(progress,total,done);
                }
            });
    }
}
