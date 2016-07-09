package com.moselin.moslmvp.request;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/4.
 */
public interface ProgressListener
{
    /**
     * 下载请求进度回调接口
     * @param progress 进度
     * @param total 总大小
     * @param done 是否完成
     */
    void progress(long progress,long total,boolean done);
}
