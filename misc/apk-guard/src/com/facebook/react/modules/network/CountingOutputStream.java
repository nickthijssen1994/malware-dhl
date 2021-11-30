package com.facebook.react.modules.network;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream
  extends FilterOutputStream
{
  private long mCount = 0L;
  
  public CountingOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void close()
    throws IOException
  {
    out.close();
  }
  
  public long getCount()
  {
    return mCount;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    out.write(paramInt);
    mCount += 1L;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    out.write(paramArrayOfByte, paramInt1, paramInt2);
    mCount += paramInt2;
  }
}
