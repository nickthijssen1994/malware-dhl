package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import javax.annotation.Nullable;

public final class FileLocker
  implements Closeable
{
  @Nullable
  private final FileLock mLock;
  private final FileOutputStream mLockFileOutputStream;
  
  private FileLocker(File paramFile)
    throws IOException
  {
    mLockFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      paramFile = mLockFileOutputStream.getChannel().lock();
      if (paramFile == null) {
        mLockFileOutputStream.close();
      }
      mLock = paramFile;
      return;
    }
    catch (Throwable paramFile)
    {
      mLockFileOutputStream.close();
      throw paramFile;
    }
  }
  
  public static FileLocker lock(File paramFile)
    throws IOException
  {
    return new FileLocker(paramFile);
  }
  
  public void close()
    throws IOException
  {
    try
    {
      FileLock localFileLock = mLock;
      if (localFileLock != null) {
        mLock.release();
      }
      mLockFileOutputStream.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      mLockFileOutputStream.close();
      throw localThrowable;
    }
  }
}
