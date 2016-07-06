package com.moselin.moslmvp.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.moselin.moslmvp.mvp.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/6.
 */
public abstract class PresenterActivity extends AppCompatActivity
{
    protected List<BasePresenter> presenters = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * 如果有presenter必须加入到list中
     * @param presenter what extends BasePresenter
     */
    protected void addPresenterToList(BasePresenter presenter){
        presenters.add(presenter);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        for (BasePresenter presenter : presenters)
        presenter.unRigistRx();
    }
}
