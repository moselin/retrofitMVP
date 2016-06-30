package com.moselin.moslmvp.mvp.view;


import java.util.Map;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public interface IBaseView<E> extends ILoadingView
{

    /**
     * 获取请求的action动作
     * @return string
     */
    String getPath();

    /**
     * 请求的参数
     * @return map
     */
    Map<String,Object> getParameters();

    /**
     * 请求错误
     * @param msg 错误信息
     */
    void onError(String msg);

    /**
     * 请求成功返回的实体
     * @param entity 实体
     */
    void onCompleted(E entity);

}
