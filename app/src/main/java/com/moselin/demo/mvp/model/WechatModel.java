package com.moselin.demo.mvp.model;

import android.util.Log;

import com.moselin.demo.request.IRequestService;
import com.moselin.moslmvp.mvp.model.IBaseModel;
import com.moselin.moslmvp.request.RequestClient;
import com.moselin.moslmvp.request.RequestSubscriber;

import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/29.
 */
public class WechatModel implements IBaseModel<WechatEntity>
{
    @Override
    public void sendRequest(String path, Map<String, Object> parameters, RequestSubscriber<WechatEntity> subscriber)
    {
        Log.v("Tag",path);
        IRequestService requestService = RequestClient.getClient().getRetrofit().create(IRequestService.class);
        requestService.postWechat(path,parameters)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
