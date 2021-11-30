package com.facebook.react.modules.network;

import java.io.IOException;
import java.io.OutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

public class ProgressRequestBody
  extends RequestBody
{
  private long mContentLength = 0L;
  private final ProgressListener mProgressListener;
  private final RequestBody mRequestBody;
  
  public ProgressRequestBody(RequestBody paramRequestBody, ProgressListener paramProgressListener)
  {
    mRequestBody = paramRequestBody;
    mProgressListener = paramProgressListener;
  }
  
  private Sink outputStreamSink(BufferedSink paramBufferedSink)
  {
    Okio.sink(new CountingOutputStream(paramBufferedSink.outputStream())
    {
      private void sendProgressUpdate()
        throws IOException
      {
        long l1 = getCount();
        long l2 = contentLength();
        ProgressListener localProgressListener = mProgressListener;
        boolean bool;
        if (l1 == l2) {
          bool = true;
        } else {
          bool = false;
        }
        localProgressListener.onProgress(l1, l2, bool);
      }
      
      public void write(int paramAnonymousInt)
        throws IOException
      {
        super.write(paramAnonymousInt);
        sendProgressUpdate();
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        super.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        sendProgressUpdate();
      }
    });
  }
  
  public long contentLength()
    throws IOException
  {
    if (mContentLength == 0L) {
      mContentLength = mRequestBody.contentLength();
    }
    return mContentLength;
  }
  
  public MediaType contentType()
  {
    return mRequestBody.contentType();
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    paramBufferedSink = Okio.buffer(outputStreamSink(paramBufferedSink));
    contentLength();
    mRequestBody.writeTo(paramBufferedSink);
    paramBufferedSink.flush();
  }
}
