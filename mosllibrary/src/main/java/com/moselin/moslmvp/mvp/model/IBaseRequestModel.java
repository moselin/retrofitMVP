package com.moselin.moslmvp.mvp.model;

import rx.Observable;
import rx.Subscriber;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/6.
 */
public interface IBaseRequestModel
{
    /**
     * 注册RxJava
     * @param observable  可观察者
     * @param subscriber 订阅者
     */
    void rigistRx(Observable observable, Subscriber subscriber);

    /**
     * 取消注册RxJava
     */
    void unRigistRx();
}
