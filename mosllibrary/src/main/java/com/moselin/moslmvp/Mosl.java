package com.moselin.moslmvp;

import android.content.Context;

import com.moselin.moslmvp.mvp.model.IRequestModel;
import com.moselin.moslmvp.request.HeaderInterceptor;
import com.moselin.moslmvp.request.ProcessInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public class Mosl
{
    public static Context context;
    public static String httpUrl;
    public static Map<String, IRequestModel> requestCount = new ConcurrentHashMap<>();
    private static OkHttpClient client;

    public static void init(Context mContext, String url)
    {
        init(mContext, url, null);

    }

    public static void init(Context mContext, String url, final Map<String, String> header)
    {
        context = mContext;
        httpUrl = url;
        requestCount.clear();
        if (header != null)
            client = new OkHttpClient.Builder().addInterceptor(new HeaderInterceptor(header))
                    .connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .build();
    }

    public static OkHttpClient getClient()
    {
        return client;
    }
}
