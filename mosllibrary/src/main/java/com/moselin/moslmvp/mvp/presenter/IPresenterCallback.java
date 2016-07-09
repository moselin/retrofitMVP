package com.moselin.moslmvp.mvp.presenter;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public interface IPresenterCallback<E>
{
    /**
     * 请求完成
     * @param entity 实体类泛型
     */
     void onCompleted(E entity);

     /**
      * 请求发生错误
      * @param code 错误码
      * @param msg 提示信息
      */
     void onError(int code, String msg);

}
