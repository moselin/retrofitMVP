package com.moselin.moslmvp.mvp.view;



/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public interface ILoadingView
{
    /**
     * 正在请求中显示加载框
     */
    void loading();

    /**
     * 请求完成关闭加载框
     */
    void dismisss();



}
