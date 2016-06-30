package com.moselin.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.moselin.demo.mvp.model.WechatEntity;
import com.moselin.demo.mvp.model.WechatModel;
import com.moselin.demo.mvp.view.WechatView;
import com.moselin.moslmvp.R;
import com.moselin.moslmvp.mvp.presenter.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{

    @Bind(R.id.tvTitle)
    TextView tvTitle;
    @Bind(R.id.tvContext)
    TextView tvContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        WechatView view = new WechatView(this);
        BasePresenter<WechatEntity> presenter = new BasePresenter<>(view, new WechatModel());
        presenter.sendRequest();
    }

    public void refreshUi(WechatEntity entity)
    {
        tvTitle.setText("请求成功");
        tvContext.setText("获取到"+entity.result.list.size()+"条数据");
    }
}
