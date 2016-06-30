package com.moselin.moslmvp.mvp.presenter;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public interface IPresenterCallback<E>
{
     void onCompleted(E entity);

     void onError(String msg);

}
