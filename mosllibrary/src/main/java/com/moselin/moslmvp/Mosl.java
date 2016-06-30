package com.moselin.moslmvp;

import android.content.Context;

import com.moselin.moslmvp.mvp.model.IBaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public class Mosl
{
    public static Context context;
    public static String httpUrl;
    public static Map<String,IBaseModel> requestCount = new ConcurrentHashMap<>();
    public static void init(Context  mContext,String url)
    {
        context = mContext;
        httpUrl = url;
        requestCount.clear();
    }
}
