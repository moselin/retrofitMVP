package com.moselin.moslmvp.mvp.presenter;

import com.moselin.moslmvp.Mosl;
import com.moselin.moslmvp.mvp.model.IRequestModel;
import com.moselin.moslmvp.mvp.view.IBaseView;
import com.moselin.moslmvp.request.RequestSubscriber;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public class RequestPresenter<E> extends BasePresenter
{
    private IBaseView<E> view;
//    private IRequestModel<E> model;

    public RequestPresenter(IBaseView<E> view, IRequestModel<E> model)
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
        if (Mosl.requestCount.isEmpty())
            view.loading();
        model.sendRequest(view.getPath(), view.getParameters(), new RequestSubscriber<>(new IPresenterCallback<E>()
        {
            @Override
            public void onCompleted(E entity)
            {

                Mosl.requestCount.remove(view.getPath());
                if (Mosl.requestCount.isEmpty())
                    view.dismisss();
                view.onCompleted(entity);
            }

            @Override
            public void onError(String msg)
            {
                view.dismisss();
                Mosl.requestCount.remove(view.getPath());
                view.onError(msg);
            }
        }),null);
        Mosl.requestCount.put(view.getPath(),model);
    }
}
