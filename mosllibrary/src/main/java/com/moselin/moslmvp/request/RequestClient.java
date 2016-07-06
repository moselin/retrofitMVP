package com.moselin.moslmvp.request;


import android.support.annotation.NonNull;

import com.moselin.moslmvp.Mosl;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/12.
 */
public class RequestClient
{
    private static RequestClient client;
    public static synchronized RequestClient getClient(){
        if (client == null)
            client = new RequestClient();
        return client;
    }

    /**
     * 平常的接口请求
     * @return retrofit
     */
    public Retrofit getRetrofit() {
        return getRetrofit(null);
    }

    /**
     * 下载文件的请求
     * @param listener 下载进度监听
     * @return retrofit
     */
    public Retrofit getRetrofit(ProgressListener listener) {
        String url = Mosl.httpUrl;
        OkHttpClient client = Mosl.getClient();
        if (listener != null){
            client = client.newBuilder().addNetworkInterceptor(new ProcessInterceptor(listener)).build();
        }
        Retrofit.Builder builder = getBuilder(url, client);
        return builder.build();
    }

    @NonNull
    private Retrofit.Builder getBuilder(String url, OkHttpClient client)
    {
        return new Retrofit.Builder()
                    //baseUrl
                    .baseUrl(url)
                    //gson转化器
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client);
    }

}
