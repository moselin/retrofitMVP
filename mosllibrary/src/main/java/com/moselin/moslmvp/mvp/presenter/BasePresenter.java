package com.moselin.moslmvp.mvp.presenter;

import com.moselin.moslmvp.mvp.model.IBaseModel;
import com.moselin.moslmvp.mvp.view.IBaseView;

import rx.subscriptions.CompositeSubscription;

/**
 * @Description P层基类
 * @Author MoseLin
 * @Date 2016/7/6.
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView>
{
    protected M model;
    protected V view;
    public CompositeSubscription sub = new CompositeSubscription();
    public void setModel(M m){
        model = m;
    }
    public void setView(V v){
        view = v;
    }
    public void setModelView(M m,V v){
        model = m;
        view = v;
    }
    /**
     * 取消注册RxJava 防止内存溢出
     */
    public void unRigistRx(){
        if (sub != null && sub.hasSubscriptions())
        sub.unsubscribe();
    }

}
