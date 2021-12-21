package com.facebook.common.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream
  extends OutputStream
{
  public PooledByteBufferOutputStream() {}
  
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
    }
  }
  
  public abstract int size();
  
  public abstract PooledByteBuffer toByteBuffer();
}
