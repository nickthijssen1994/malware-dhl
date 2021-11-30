package com.facebook.react.devsupport;

import android.os.Build.VERSION;

class WindowOverlayCompat
{
  private static final int ANDROID_OREO = 26;
  private static final int TYPE_APPLICATION_OVERLAY = 2038;
  static final int TYPE_SYSTEM_ALERT;
  static final int TYPE_SYSTEM_OVERLAY;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    int j = 2038;
    if (i < 26) {
      i = 2003;
    } else {
      i = 2038;
    }
    TYPE_SYSTEM_ALERT = i;
    i = j;
    if (Build.VERSION.SDK_INT < 26) {
      i = 2006;
    }
    TYPE_SYSTEM_OVERLAY = i;
  }
  
  WindowOverlayCompat() {}
}
