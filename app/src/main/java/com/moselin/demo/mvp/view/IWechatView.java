package com.moselin.demo.mvp.view;

import com.moselin.demo.mvp.model.WechatEntity;
import com.moselin.moslmvp.mvp.view.IBaseView;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/8.
 */
public interface IWechatView extends IBaseView
{
    /**
     * 获取请求的action动作
     * @return string
     */
    String getPath();

    /**
     * 请求的参数
     * @return map
     */
    Map<String,Object> getParameters();

    /**
     * 请求错误
     * @param code 错误代码
     * @param msg 错误信息
     */
    void onError(int code,String msg);

    /**
     * 请求成功返回的实体
     * @param entity 实体
     */
    void onCompleted(WechatEntity entity);
    /**
     * 请求成功返回的body
     * @param entity body
     */
    void onDownload(ResponseBody entity);

    /**
     * 显示进度
     * @param progress  进度
     * @param total 总数
     * @param done 是否完成
     */
    void progress(long progress, long total, boolean done);
}
