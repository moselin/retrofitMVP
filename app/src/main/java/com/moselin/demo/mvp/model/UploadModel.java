package com.moselin.demo.mvp.model;

import com.moselin.demo.request.IRequestService;
import com.moselin.moslmvp.mvp.model.IMPLRequestModel;
import com.moselin.moslmvp.request.ProgressListener;
import com.moselin.moslmvp.request.RequestSubscriber;

import java.util.Map;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/6.
 */
public class UploadModel<E> extends IMPLRequestModel<E>
{
    @Override
    public void sendRequest(String path, Map<String, Object> parameters, RequestSubscriber<E> subscriber, ProgressListener listener)
    {
        IRequestService requestService = getRetrofit(listener).create(IRequestService.class);
        rigistRx(requestService.upload(path,"上传",parameters),subscriber);
    }
}
