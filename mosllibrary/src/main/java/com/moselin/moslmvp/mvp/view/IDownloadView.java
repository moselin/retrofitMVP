package com.moselin.moslmvp.mvp.view;

/**
 * @Description 下载请求一般都可以直接继承或实现此接口
 * @Author MoseLin
 * @Date 2016/7/5.
 */
public interface IDownloadView<E> extends ICommonView<E>
{
    /**
     * 显示进度
     * @param progress  进度
     * @param total 总数
     * @param done 是否完成
     */
    void progress(long progress, long total, boolean done);
}
