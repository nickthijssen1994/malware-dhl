package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class FileIoHandler
  implements Runnable
{
  private static final long FILE_TTL = 30000L;
  private static final String LOGTAG = JSPackagerClient.class.getSimpleName();
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private int mNextHandle = 1;
  private final Map<Integer, TtlFileInputStream> mOpenFiles = new HashMap();
  private final Map<String, RequestHandler> mRequestHandlers = new HashMap();
  
  public FileIoHandler()
  {
    mRequestHandlers.put("fopen", new RequestOnlyHandler()
    {
      public void onRequest(Object paramAnonymousObject, Responder paramAnonymousResponder)
      {
        localMap = mOpenFiles;
        for (;;)
        {
          try
          {
            localObject = (JSONObject)paramAnonymousObject;
            if (localObject == null) {}
          }
          catch (Throwable paramAnonymousObject)
          {
            Object localObject;
            throw paramAnonymousObject;
          }
          try
          {
            paramAnonymousObject = ((JSONObject)localObject).optString("mode");
            if (paramAnonymousObject != null)
            {
              localObject = ((JSONObject)localObject).optString("filename");
              if (localObject != null)
              {
                boolean bool = paramAnonymousObject.equals("r");
                if (bool)
                {
                  paramAnonymousObject = FileIoHandler.this;
                  paramAnonymousResponder.respond(Integer.valueOf(paramAnonymousObject.addOpenFile((String)localObject)));
                  continue;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("unsupported mode: ");
                ((StringBuilder)localObject).append(paramAnonymousObject);
                paramAnonymousObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
                throw paramAnonymousObject;
              }
              throw new Exception("missing params.filename");
            }
            throw new Exception("missing params.mode");
          }
          catch (Exception paramAnonymousObject)
          {
            paramAnonymousResponder.error(paramAnonymousObject.toString());
            return;
          }
        }
        throw new Exception("params must be an object { mode: string, filename: string }");
      }
    });
    mRequestHandlers.put("fclose", new RequestOnlyHandler()
    {
      public void onRequest(Object paramAnonymousObject, Responder paramAnonymousResponder)
      {
        localMap = mOpenFiles;
        for (;;)
        {
          try
          {
            if ((paramAnonymousObject instanceof Number)) {
              localObject1 = FileIoHandler.this;
            }
          }
          catch (Throwable paramAnonymousObject)
          {
            Object localObject1;
            Object localObject2;
            throw paramAnonymousObject;
          }
          try
          {
            localObject1 = mOpenFiles;
            localObject2 = (Integer)paramAnonymousObject;
            localObject1 = ((Map)localObject1).get(Integer.valueOf(((Integer)localObject2).intValue()));
            localObject1 = (FileIoHandler.TtlFileInputStream)localObject1;
            if (localObject1 != null)
            {
              localObject2 = FileIoHandler.this;
              localObject2 = mOpenFiles;
              paramAnonymousObject = (Integer)paramAnonymousObject;
              ((Map)localObject2).remove(Integer.valueOf(paramAnonymousObject.intValue()));
              ((FileIoHandler.TtlFileInputStream)localObject1).close();
              paramAnonymousResponder.respond("");
              continue;
            }
            throw new Exception("invalid file handle, it might have timed out");
          }
          catch (Exception paramAnonymousObject)
          {
            paramAnonymousResponder.error(paramAnonymousObject.toString());
            return;
          }
        }
        throw new Exception("params must be a file handle");
      }
    });
    mRequestHandlers.put("fread", new RequestOnlyHandler()
    {
      public void onRequest(Object paramAnonymousObject, Responder paramAnonymousResponder)
      {
        localMap = mOpenFiles;
        for (;;)
        {
          try
          {
            paramAnonymousObject = (JSONObject)paramAnonymousObject;
            if (paramAnonymousObject == null) {}
          }
          catch (Throwable paramAnonymousObject)
          {
            int i;
            throw paramAnonymousObject;
          }
          try
          {
            i = paramAnonymousObject.optInt("file");
            if (i != 0)
            {
              int j = paramAnonymousObject.optInt("size");
              if (j != 0)
              {
                paramAnonymousObject = FileIoHandler.this;
                paramAnonymousObject = mOpenFiles.get(Integer.valueOf(i));
                paramAnonymousObject = (FileIoHandler.TtlFileInputStream)paramAnonymousObject;
                if (paramAnonymousObject != null)
                {
                  paramAnonymousResponder.respond(paramAnonymousObject.read(j));
                  continue;
                }
                throw new Exception("invalid file handle, it might have timed out");
              }
              throw new Exception("invalid or missing read size");
            }
            throw new Exception("invalid or missing file handle");
          }
          catch (Exception paramAnonymousObject)
          {
            paramAnonymousResponder.error(paramAnonymousObject.toString());
            return;
          }
        }
        throw new Exception("params must be an object { file: handle, size: number }");
      }
    });
  }
  
  private int addOpenFile(String paramString)
    throws FileNotFoundException
  {
    int i = mNextHandle;
    mNextHandle = (i + 1);
    mOpenFiles.put(Integer.valueOf(i), new TtlFileInputStream(paramString));
    if (mOpenFiles.size() == 1) {
      mHandler.postDelayed(this, 30000L);
    }
    return i;
  }
  
  public Map handlers()
  {
    return mRequestHandlers;
  }
  
  public void run()
  {
    Map localMap = mOpenFiles;
    try
    {
      Iterator localIterator = mOpenFiles.values().iterator();
      while (localIterator.hasNext())
      {
        TtlFileInputStream localTtlFileInputStream = (TtlFileInputStream)localIterator.next();
        if (localTtlFileInputStream.expiredTtl())
        {
          localIterator.remove();
          try
          {
            localTtlFileInputStream.close();
          }
          catch (IOException localIOException)
          {
            String str = LOGTAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("closing expired file failed: ");
            localStringBuilder.append(localIOException.toString());
            FLog.e(str, localStringBuilder.toString());
          }
        }
      }
      if (!mOpenFiles.isEmpty()) {
        mHandler.postDelayed(this, 30000L);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private static class TtlFileInputStream
  {
    private final FileInputStream mStream;
    private long mTtl;
    
    public TtlFileInputStream(String paramString)
      throws FileNotFoundException
    {
      mStream = new FileInputStream(paramString);
      mTtl = (System.currentTimeMillis() + 30000L);
    }
    
    private void extendTtl()
    {
      mTtl = (System.currentTimeMillis() + 30000L);
    }
    
    public void close()
      throws IOException
    {
      mStream.close();
    }
    
    public boolean expiredTtl()
    {
      return System.currentTimeMillis() >= mTtl;
    }
    
    public String read(int paramInt)
      throws IOException
    {
      extendTtl();
      byte[] arrayOfByte = new byte[paramInt];
      return Base64.encodeToString(arrayOfByte, 0, mStream.read(arrayOfByte), 0);
    }
  }
}
