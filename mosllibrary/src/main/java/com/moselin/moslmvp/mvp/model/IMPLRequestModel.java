package com.moselin.moslmvp.mvp.model;

import com.moselin.moslmvp.request.ProgressListener;
import com.moselin.moslmvp.request.RequestClient;
import com.moselin.moslmvp.request.RequestSubscriber;

import java.util.Map;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/6.
 */
public abstract class IMPLRequestModel<E> implements IRequestModel<E>
{
    CompositeSubscription sub = null;
    @Override
    public abstract void sendRequest(String path, Map<String, Object> parameters, RequestSubscriber<E> subscriber, ProgressListener listener);
    @Override
    public void rigistRx(Observable observable, Subscriber subscriber)
    {
        if (sub == null)
            sub = new CompositeSubscription();
        sub.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    @Override
    public void unRigistRx()
    {
        if (sub != null&&sub.hasSubscriptions())
            sub.unsubscribe();
    }

    @Override
    public Retrofit getRetrofit(ProgressListener listener)
    {
        return RequestClient.getClient().getRetrofit(listener);
    }
}