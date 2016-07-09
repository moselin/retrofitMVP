package com.moselin.demo.mvp.model;

import com.moselin.demo.request.IRequestService;
import com.moselin.moslmvp.request.ProgressListener;
import com.moselin.moslmvp.request.RequestClient;
import com.moselin.moslmvp.request.RequestSubscriber;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/8.
 */
public class WechatModeImpl implements WechatModelI
{
    @Override
    public Subscription sendRequest(String path, Map<String, Object> parameters, RequestSubscriber<WechatEntity> subscriber)
    {
        IRequestService requestService = RequestClient.getClient().getRetrofit().create(IRequestService.class);
        return requestService.postWechat(path, parameters).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public Subscription downRequest(RequestSubscriber<ResponseBody> subscriber, ProgressListener listener)
    {
        IRequestService requestService = RequestClient.getClient().getRetrofit(listener).create(IRequestService.class);
        return requestService.downLoad().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
