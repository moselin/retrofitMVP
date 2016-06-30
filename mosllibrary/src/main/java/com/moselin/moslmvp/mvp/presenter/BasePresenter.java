package com.moselin.moslmvp.mvp.presenter;

import com.moselin.moslmvp.Mosl;
import com.moselin.moslmvp.mvp.model.IBaseModel;
import com.moselin.moslmvp.mvp.view.IBaseView;
import com.moselin.moslmvp.request.RequestSubscriber;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/24.
 */
public class BasePresenter<E>
{
    private IBaseView<E> view;
    private IBaseModel model;

    public BasePresenter(IBaseView<E> view, IBaseModel model)
    {
        this.view = view;
        this.model = model;
    }

    /**
     * 发起网络请求
     */
    public void sendRequest()
    {
        if (Mosl.requestCount.isEmpty())
            view.loading();
//        if (Mosl.requestCount.get(view.getPath()) != null)
//        {
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
            }));
            Mosl.requestCount.put(view.getPath(),model);
//        }
    }
}
