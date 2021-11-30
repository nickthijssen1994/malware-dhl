package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

@ReactModule(name="StatusBarManager")
public class StatusBarModule
  extends ReactContextBaseJavaModule
{
  private static final String DEFAULT_BACKGROUND_COLOR_KEY = "DEFAULT_BACKGROUND_COLOR";
  private static final String HEIGHT_KEY = "HEIGHT";
  public static final String NAME = "StatusBarManager";
  
  public StatusBarModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  public Map getConstants()
  {
    Object localObject = getReactApplicationContext();
    Activity localActivity = getCurrentActivity();
    int i = ((Context)localObject).getResources().getIdentifier("status_bar_height", "dimen", "android");
    float f;
    if (i > 0) {
      f = PixelUtil.toDIPFromPixel(((Context)localObject).getResources().getDimensionPixelSize(i));
    } else {
      f = 0.0F;
    }
    String str = "black";
    localObject = str;
    if (localActivity != null)
    {
      localObject = str;
      if (Build.VERSION.SDK_INT >= 21) {
        localObject = String.format("#%06X", new Object[] { Integer.valueOf(localActivity.getWindow().getStatusBarColor() & 0xFFFFFF) });
      }
    }
    return MapBuilder.get("HEIGHT", Float.valueOf(f), "DEFAULT_BACKGROUND_COLOR", localObject);
  }
  
  public String getName()
  {
    return "StatusBarManager";
  }
  
  public void setColor(final int paramInt, final boolean paramBoolean)
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
    {
      FLog.warn("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext())
      {
        public void runGuarded()
        {
          localActivity.getWindow().addFlags(Integer.MIN_VALUE);
          if (paramBoolean)
          {
            int i = localActivity.getWindow().getStatusBarColor();
            ValueAnimator localValueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
            localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                val$activity.getWindow().setStatusBarColor(((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue());
              }
            });
            localValueAnimator.setDuration(300L).setStartDelay(0L);
            localValueAnimator.start();
            return;
          }
          localActivity.getWindow().setStatusBarColor(paramInt);
        }
      });
    }
  }
  
  public void setHidden(final boolean paramBoolean)
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
    {
      FLog.warn("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
      return;
    }
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          localActivity.getWindow().addFlags(1024);
          localActivity.getWindow().clearFlags(2048);
          return;
        }
        localActivity.getWindow().addFlags(2048);
        localActivity.getWindow().clearFlags(1024);
      }
    });
  }
  
  public void setStyle(final String paramString)
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
    {
      FLog.warn("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      UiThreadUtil.runOnUiThread(new Runnable()
      {
        public void run()
        {
          View localView = localActivity.getWindow().getDecorView();
          int i = localView.getSystemUiVisibility();
          if ("dark-content".equals(paramString)) {
            i |= 0x2000;
          } else {
            i &= 0xDFFF;
          }
          localView.setSystemUiVisibility(i);
        }
      });
    }
  }
  
  public void setTranslucent(final boolean paramBoolean)
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
    {
      FLog.warn("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext())
      {
        public void runGuarded()
        {
          View localView = localActivity.getWindow().getDecorView();
          if (paramBoolean) {
            localView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
            {
              public WindowInsets onApplyWindowInsets(View paramAnonymous2View, WindowInsets paramAnonymous2WindowInsets)
              {
                paramAnonymous2View = paramAnonymous2View.onApplyWindowInsets(paramAnonymous2WindowInsets);
                return paramAnonymous2View.replaceSystemWindowInsets(paramAnonymous2View.getSystemWindowInsetLeft(), 0, paramAnonymous2View.getSystemWindowInsetRight(), paramAnonymous2View.getSystemWindowInsetBottom());
              }
            });
          } else {
            localView.setOnApplyWindowInsetsListener(null);
          }
          ViewCompat.requestApplyInsets(localView);
        }
      });
    }
  }
}
