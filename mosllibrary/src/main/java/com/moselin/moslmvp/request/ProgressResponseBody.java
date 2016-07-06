package com.moselin.moslmvp.request;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/7/4.
 */
public class ProgressResponseBody extends ResponseBody
{
    private ProgressListener listener;
    private ResponseBody body;
    private BufferedSource bufferedSource;

    public ProgressResponseBody(ResponseBody body, ProgressListener listener)
    {
        this.listener = listener;
        this.body = body;
    }

    @Override
    public MediaType contentType()
    {
        return body.contentType();
    }

    @Override
    public long contentLength()
    {
        return body.contentLength();
    }

    @Override
    public BufferedSource source()
    {
        if (bufferedSource == null) {
            bufferedSource = Okio.buffer(source(body.source()));
        }
        return bufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            long totalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException
            {
                long bytesRead = super.read(sink, byteCount);
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                if (listener != null)
                listener.progress(totalBytesRead, body.contentLength(), bytesRead == -1);
                return bytesRead;
            }
        };
    }
}
