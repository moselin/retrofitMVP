package com.moselin.moslmvp.mvp.view;


import java.util.Map;

/**
 * @Description 公共的view接口，一般的请求一般都可以直接继承或实现此接口
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public interface ICommonView<E> extends ILoadingViewI
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
