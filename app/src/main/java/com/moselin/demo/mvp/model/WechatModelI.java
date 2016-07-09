package com.moselin.demo.mvp.model;

import com.moselin.moslmvp.mvp.model.IBaseModel;
import com.moselin.moslmvp.request.ProgressListener;
import com.moselin.moslmvp.request.RequestSubscriber;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Subscription;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/8.
 */
public interface WechatModelI extends IBaseModel
{
    /**
     * 获取平常的请求数据
     * @param path action动作路径
     * @param parameters 提交的参数
     * @param subscriber 订阅者
     * @return 订阅者
     */
     Subscription sendRequest(String path, Map<String,Object> parameters, RequestSubscriber<WechatEntity> subscriber);

     /**
      * 下载请求
      * @param subscriber 订阅者
      * @param listener 进度监听
      * @return 订阅者
     */
     Subscription downRequest(RequestSubscriber<ResponseBody> subscriber, ProgressListener listener);
}
