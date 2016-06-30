package com.moselin.moslmvp.request;


import com.moselin.moslmvp.Mosl;

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
    private Retrofit retrofit;
    RequestClient() {
        retrofit = new Retrofit.Builder()
                //baseUrl
                .baseUrl(Mosl.httpUrl)
                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public static synchronized RequestClient getClient(){
        if (client == null)
            client = new RequestClient();
        return client;
    }
    public Retrofit getRetrofit() {

        return retrofit;
    }

}
