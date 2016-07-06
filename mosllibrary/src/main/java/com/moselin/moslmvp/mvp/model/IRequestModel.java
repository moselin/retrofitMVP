package com.moselin.moslmvp.mvp.model;

import com.moselin.moslmvp.request.ProgressListener;
import com.moselin.moslmvp.request.RequestSubscriber;

import java.util.Map;

import retrofit2.Retrofit;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public interface IRequestModel<E> extends IBaseRequestModel
{
    /**
     * 发起网络请求
     * @param path  域名后加的地址路径
     * @param parameters 参数
     * @param subscriber 订阅者回调
     * @param listener 下载进度回调
     */
     void sendRequest(String path, Map<String, Object> parameters, RequestSubscriber<E> subscriber,ProgressListener listener);

    /**
     * 获取到retrofit对象
     * @param listener 进度监听器   为空则不是下载的请求
     * @return Retrofit
     */
     Retrofit getRetrofit(ProgressListener listener);
}
