package com.moselin.moslmvp.request;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/4.
 */
public interface ProgressListener
{
    void progress(long progress,long total,boolean done);
}
