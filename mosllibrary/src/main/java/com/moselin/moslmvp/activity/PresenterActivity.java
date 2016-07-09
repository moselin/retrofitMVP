package com.moselin.moslmvp.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.moselin.moslmvp.mvp.presenter.BasePresenter;
import com.moselin.moslmvp.util.TUitl;

import butterknife.ButterKnife;

/**
 * @Description 要用Mvp模式activity须继承此类
 * @Author MoseLin
 * @Date 2016/7/6.
 */
public abstract class PresenterActivity<P extends BasePresenter> extends AppCompatActivity
{
    protected P presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        presenter = TUitl.getT(this,0);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);//bind 注解
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (presenter != null) presenter.unRigistRx();
        ButterKnife.unbind(this);//unbind 注解
    }
}
