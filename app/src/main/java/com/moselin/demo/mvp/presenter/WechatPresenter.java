package com.moselin.demo.mvp.presenter;

import com.moselin.demo.mvp.model.WechatEntity;
import com.moselin.demo.mvp.model.WechatModelI;
import com.moselin.demo.mvp.view.IWechatView;
import com.moselin.moslmvp.mvp.presenter.BasePresenter;
import com.moselin.moslmvp.mvp.presenter.IPresenterCallback;
import com.moselin.moslmvp.request.ProgressListener;
import com.moselin.moslmvp.request.RequestSubscriber;

import okhttp3.ResponseBody;
import rx.Subscription;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/8.
 */
public class WechatPresenter extends BasePresenter<WechatModelI,IWechatView>
{

    public void getWechat(){
        Subscription subscription = model.sendRequest(view.getPath(),view.getParameters(),new RequestSubscriber<WechatEntity>(new IPresenterCallback<WechatEntity>()

        {
            @Override
            public void onCompleted(WechatEntity entity)
            {
                view.onCompleted(entity);
            }

            @Override
            public void onError(int code,String msg)
            {
                view.onError(code,msg);
            }
        }){

        });
        sub.add(subscription);
    }
    public void down(){
        Subscription subscription = model.downRequest(new RequestSubscriber<>(new IPresenterCallback<ResponseBody>()

        {
            @Override
            public void onCompleted(ResponseBody entity)
            {
                view.onDownload(entity);
            }

            @Override
            public void onError(int code,String msg)
            {
                view.onError(code,msg);
            }
        }), new ProgressListener()
        {
            @Override
            public void progress(long progress, long total, boolean done)
            {
                view.progress(progress,total,done);
            }
        });
        sub.add(subscription);
    }
}
