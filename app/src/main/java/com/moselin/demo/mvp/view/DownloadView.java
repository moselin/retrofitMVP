package com.moselin.demo.mvp.view;

import android.util.Log;

import com.moselin.demo.activity.MainActivity;
import com.moselin.moslmvp.mvp.view.IDownloadView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/4.
 */
public class DownloadView implements IDownloadView<ResponseBody>
{


    private final MainActivity activity;

    public DownloadView(MainActivity mainActivity)
    {
        this.activity = mainActivity;
    }

    @Override
    public String getPath()
    {
        return "";
    }

    @Override
    public Map<String, Object> getParameters()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("pno", 1);
        map.put("ps", 20);
        map.put("key", "adbabe9d1fec9d2a03e318d51e724cdc");
        return null;
    }

    @Override
    public void onError(String msg)
    {
        Log.v("Tag",msg);
    }

    @Override
    public void onCompleted(ResponseBody entity)
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

    @Override
    public void loading()
    {

    }

    @Override
    public void dismisss()
    {

    }
}