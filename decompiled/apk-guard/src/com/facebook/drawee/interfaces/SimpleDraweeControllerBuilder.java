package com.facebook.drawee.interfaces;

import android.net.Uri;

public abstract interface SimpleDraweeControllerBuilder
{
  public abstract DraweeController build();
  
  public abstract SimpleDraweeControllerBuilder setCallerContext(Object paramObject);
  
  public abstract SimpleDraweeControllerBuilder setOldController(DraweeController paramDraweeController);
  
  public abstract SimpleDraweeControllerBuilder setUri(Uri paramUri);
  
  public abstract SimpleDraweeControllerBuilder setUri(String paramString);
}
