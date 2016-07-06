package com.moselin.moslmvp.mvp.presenter;

import com.moselin.moslmvp.mvp.model.IRequestModel;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/6.
 */
public abstract class BasePresenter
{
    protected IRequestModel model;

    /**
     * 取消注册RxJava 防止内存溢出
     */
    public abstract void unRigistRx();

    /**
     * 发起网络请求
     */
    public abstract void doRequest();
}
