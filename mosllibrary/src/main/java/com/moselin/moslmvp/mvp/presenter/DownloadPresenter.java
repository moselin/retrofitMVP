package com.moselin.moslmvp.mvp.presenter;

import com.moselin.moslmvp.mvp.model.IRequestModel;
import com.moselin.moslmvp.mvp.view.IDownloadView;
import com.moselin.moslmvp.request.ProgressListener;
import com.moselin.moslmvp.request.RequestSubscriber;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/5.
 */
public class DownloadPresenter<E> extends BasePresenter
{
    private IDownloadView<E> view;

    public DownloadPresenter(IDownloadView<E> view, IRequestModel<E> model)
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public void unRigistRx()
    {
        model.unRigistRx();
    }

    @Override
    public void doRequest()
    {
        model.sendRequest(view.getPath(), view.getParameters(), new RequestSubscriber<>(new IPresenterCallback<E>()
        {
            @Override
            public void onCompleted(E entity)
            {

                view.dismisss();
                view.onCompleted(entity);
            }

            @Override
            public void onError(String msg)
            {
                view.dismisss();
                view.onError(msg);
            }
        }), new ProgressListener()
        {
            @Override
            public void progress(long progress, long total, boolean done)
            {
                view.progress(progress,total,done);
            }
        });
    }
}
