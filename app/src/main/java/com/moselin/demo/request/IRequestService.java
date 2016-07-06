package com.moselin.demo.request;




import com.moselin.demo.mvp.model.WechatEntity;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
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
    //http://119.147.33.16/dd.myapp.com/16891/8D76D0317DC5B72E1830247CA311516F.apk?mkey=577a2d3f08ca1dcf&f=2284&c=0&fsname=com.moselin.ddu_1.1_2.apk&p=.apk
    @GET("16891/8D76D0317DC5B72E1830247CA311516F.apk?mkey=577a2d3f08ca1dcf&f=2284&c=0&fsname=com.moselin.ddu_1.1_2.apk&p=.apk")
    Observable<ResponseBody> downLoad();

    @Multipart
    @POST("{action}")
    Observable<String> upload(@Path("action") String path,@Part("filedes") String desc, @PartMap Map<String, Object> parameters);
}
