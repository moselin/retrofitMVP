package com.moselin.moslmvp.mvp.view;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/5.
 */
public interface IDownloadView<E> extends IBaseView<E>
{
    /**
     * 显示进度
     * @param progress  进度
     * @param total 总数
     * @param done 是否完成
     */
    void progress(long progress, long total, boolean done);
}
