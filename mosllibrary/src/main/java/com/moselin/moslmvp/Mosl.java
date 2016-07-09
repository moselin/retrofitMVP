package com.moselin.moslmvp;

import android.content.Context;

import com.moselin.moslmvp.request.HeaderInterceptor;
import com.moselin.moslmvp.request.RequestCacheInterceptor;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public class Mosl
{
    public static Context context;
    public static String httpUrl;// 请求地址域名
    private static OkHttpClient client;

    /**
     * 请求无header初始化
     * @param mContext Application context
     * @param url look httpUrl
     */
    public static void init(Context mContext, String url)
    {
        init(mContext, url, null);

    }

    /**
     * 给请求添加header
     * @param mContext Application context
     * @param url look httpUrl
     * @param header request header
     */
    public static void init(Context mContext, String url, final Map<String, String> header)
    {
        context = mContext;
        httpUrl = url;
        //http cache path
        File cacheFile = new File(mContext.getCacheDir(), "cache");
        //cache size
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
        //init OkhttpClient
        client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new RequestCacheInterceptor(context))
                .connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .cache(cache)
                .build();
        if (header != null)
        {
            client.newBuilder().addInterceptor(new HeaderInterceptor(header));
        }
    }

    public static OkHttpClient getClient()
    {
        return client;
    }
}
