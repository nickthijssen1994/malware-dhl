package com.facebook.react.views.image;

import android.net.Uri;

public abstract interface GlobalImageLoadListener
{
  public abstract void onLoadAttempt(Uri paramUri);
}
