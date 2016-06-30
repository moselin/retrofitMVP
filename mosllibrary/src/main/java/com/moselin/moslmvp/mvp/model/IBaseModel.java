package com.moselin.moslmvp.mvp.model;

import com.moselin.moslmvp.request.RequestSubscriber;

import java.util.Map;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public interface IBaseModel<E>
{
    /**
     * 发起网络请求
     * @param path  域名后加的地址路径
     * @param parameters 参数
     */
     void sendRequest(String path, Map<String, Object> parameters, RequestSubscriber<E> subscriber);
}
