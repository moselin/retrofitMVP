package com.moselin.moslmvp.request;

import com.moselin.moslmvp.mvp.presenter.IPresenterCallback;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public class RequestSubscriber<E> extends Subscriber<E>
{

    private IPresenterCallback<E> callback;
    public RequestSubscriber(IPresenterCallback<E> callback){
        this.callback = callback;
    }
    @Override
    public void onCompleted()
    {
    }

    @Override
    public void onError(Throwable e)
    {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络出错了啦";
            }
            callback.onError(msg);
        } else {
            callback.onError(e.getMessage());
        }
    }

    @Override
    public void onNext(E o)
    {
        callback.onCompleted(o);
    }
}
