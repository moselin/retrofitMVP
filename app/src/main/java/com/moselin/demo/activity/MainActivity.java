package com.moselin.demo.activity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import com.moselin.demo.mvp.model.WechatRequestModel;
import com.moselin.demo.mvp.model.WechatEntity;
import com.moselin.demo.mvp.view.WechatView;
import com.moselin.moslmvp.R;
import com.moselin.moslmvp.activity.PresenterActivity;
import com.moselin.moslmvp.mvp.presenter.RequestPresenter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class MainActivity extends PresenterActivity
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
        RequestPresenter<WechatEntity> presenter = new RequestPresenter<>(view, new WechatRequestModel<WechatEntity>());
        presenter.doRequest();
        addPresenterToList(presenter);
//        DownloadView downloadView = new DownloadView(this);
//        DownloadPresenter<ResponseBody> downloadPresenter = new DownloadPresenter<>(downloadView,new DownloadModel<ResponseBody>());
//        downloadPresenter.doRequest();
//        addPresenterToList(downloadPresenter);
    }

    public void refreshUi(WechatEntity entity)
    {
        tvTitle.setText("请求成功");
        tvContext.setText("获取到"+entity.result.list.size()+"条数据");
    }

    public void refreshDownloadUi(ResponseBody entity)
    {

        try
        {
            InputStream is = entity.byteStream();
            File file = new File(Environment.getExternalStorageDirectory(),"DD精选.apk");
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1){
               fos.write(bytes,0,len);
                fos.flush();
            }
            bis.close();
            fos.close();
            is.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void updateProgress(long progress, long total, boolean done)
    {
        tvTitle.setText(String.format("进度：%d%%\n",(100 * progress) / total));
        tvContext.setText("总大小："+total);
    }


}
