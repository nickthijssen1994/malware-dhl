package com.facebook.common.memory;

import java.io.Closeable;
import java.nio.ByteBuffer;

public abstract interface PooledByteBuffer
  extends Closeable
{
  public abstract void close();
  
  public abstract ByteBuffer getByteBuffer();
  
  public abstract long getNativePtr();
  
  public abstract boolean isClosed();
  
  public abstract byte read(int paramInt);
  
  public abstract int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public abstract int size();
  
  public static class ClosedException
    extends RuntimeException
  {
    public ClosedException()
    {
      super();
    }
  }
}
