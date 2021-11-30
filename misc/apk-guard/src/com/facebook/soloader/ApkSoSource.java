package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

public class ApkSoSource
  extends ExtractFromZipSoSource
{
  private static final byte APK_SO_SOURCE_SIGNATURE_VERSION = 2;
  private static final byte LIBS_DIR_DOESNT_EXIST = 1;
  private static final byte LIBS_DIR_DONT_CARE = 0;
  private static final byte LIBS_DIR_SNAPSHOT = 2;
  private static final String PAGE_KEY = "ApkSoSource";
  public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
  private final int mFlags;
  
  public ApkSoSource(Context paramContext, File paramFile, String paramString, int paramInt)
  {
    super(paramContext, paramString, paramFile, "^lib/([^/]+)/([^/]+\\.so)$");
    mFlags = paramInt;
  }
  
  public ApkSoSource(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext, new File(getApplicationInfosourceDir), paramString, paramInt);
  }
  
  protected byte[] getDepsBlock()
    throws IOException
  {
    Object localObject = mZipFileName.getCanonicalFile();
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeByte((byte)2);
      localParcel.writeString(((File)localObject).getPath());
      localParcel.writeLong(((File)localObject).lastModified());
      localParcel.writeInt(SysUtil.getAppVersionCode(mContext));
      int i = mFlags;
      if ((i & 0x1) == 0)
      {
        localParcel.writeByte((byte)0);
        localObject = localParcel.marshall();
        localParcel.recycle();
        return localObject;
      }
      localObject = mContext.getApplicationInfo().nativeLibraryDir;
      if (localObject == null)
      {
        localParcel.writeByte((byte)1);
        localObject = localParcel.marshall();
        localParcel.recycle();
        return localObject;
      }
      localObject = new File((String)localObject).getCanonicalFile();
      boolean bool = ((File)localObject).exists();
      if (!bool)
      {
        localParcel.writeByte((byte)1);
        localObject = localParcel.marshall();
        localParcel.recycle();
        return localObject;
      }
      localParcel.writeByte((byte)2);
      localParcel.writeString(((File)localObject).getPath());
      localParcel.writeLong(((File)localObject).lastModified());
      localObject = localParcel.marshall();
      localParcel.recycle();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localParcel.recycle();
      throw localThrowable;
    }
  }
  
  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ApkUnpacker(this);
  }
  
  protected class ApkUnpacker
    extends ExtractFromZipSoSource.ZipUnpacker
  {
    private final int mFlags = mFlags;
    private File mLibDir = new File(mContext.getApplicationInfo().nativeLibraryDir);
    
    ApkUnpacker(ExtractFromZipSoSource paramExtractFromZipSoSource)
      throws IOException
    {
      super(paramExtractFromZipSoSource);
    }
    
    protected boolean shouldExtract(ZipEntry paramZipEntry, String paramString)
    {
      String str = paramZipEntry.getName();
      boolean bool2 = paramString.equals(mCorruptedLib);
      boolean bool1 = true;
      if (bool2)
      {
        mCorruptedLib = null;
        paramZipEntry = String.format("allowing consideration of corrupted lib %s", new Object[] { paramString });
      }
      else if ((mFlags & 0x1) == 0)
      {
        paramZipEntry = new StringBuilder();
        paramZipEntry.append("allowing consideration of ");
        paramZipEntry.append(str);
        paramZipEntry.append(": self-extraction preferred");
        paramZipEntry = paramZipEntry.toString();
      }
      else
      {
        File localFile = new File(mLibDir, paramString);
        if (!localFile.isFile())
        {
          paramZipEntry = String.format("allowing considering of %s: %s not in system lib dir", new Object[] { str, paramString });
        }
        else
        {
          long l1 = localFile.length();
          long l2 = paramZipEntry.getSize();
          if (l1 != l2)
          {
            paramZipEntry = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", new Object[] { localFile, Long.valueOf(l1), Long.valueOf(l2) });
          }
          else
          {
            paramZipEntry = new StringBuilder();
            paramZipEntry.append("not allowing consideration of ");
            paramZipEntry.append(str);
            paramZipEntry.append(": deferring to libdir");
            paramZipEntry = paramZipEntry.toString();
            bool1 = false;
          }
        }
      }
      Log.d("ApkSoSource", paramZipEntry);
      return bool1;
    }
  }
}
