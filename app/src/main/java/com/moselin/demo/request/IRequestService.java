package com.moselin.demo.request;




import com.moselin.demo.mvp.model.WechatEntity;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * @Description 请求服务
 * @Author MoseLin
 * @Date 2016/6/6.
 */
public interface IRequestService
{
    @POST("{action}")
    Observable<WechatEntity> postWechat(@Path("action") String path, @QueryMap Map<String, Object> parameters);

    @GET("{action}")
    Observable<WechatEntity> getWechat(@Path("action") String path, @QueryMap Map<String, Object> parameters);

}
