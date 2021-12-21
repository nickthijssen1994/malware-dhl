package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Intent;

public abstract interface ActivityEventListener
{
  public abstract void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onNewIntent(Intent paramIntent);
}
