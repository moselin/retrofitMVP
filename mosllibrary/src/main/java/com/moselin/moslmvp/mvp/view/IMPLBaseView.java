package com.moselin.moslmvp.mvp.view;


import java.util.Map;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public abstract class IMPLBaseView<E> implements IBaseView<E>
{

    @Override
    public void loading()
    {

    }

    @Override
    public void dismisss()
    {

    }

    @Override
    public abstract String getPath();


    @Override
    public abstract Map<String, Object> getParameters();

    @Override
    public abstract void onError(String msg);

    @Override
    public abstract void onCompleted(E entity);
}
