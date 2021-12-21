package com.facebook.react.views.progressbar;

import android.content.Context;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="AndroidProgressBar")
public class ReactProgressBarViewManager
  extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode>
{
  static final String DEFAULT_STYLE = "Normal";
  static final String PROP_ANIMATING = "animating";
  static final String PROP_INDETERMINATE = "indeterminate";
  static final String PROP_PROGRESS = "progress";
  static final String PROP_STYLE = "styleAttr";
  public static final String REACT_CLASS = "AndroidProgressBar";
  private static Object sProgressBarCtorLock = new Object();
  
  public ReactProgressBarViewManager() {}
  
  public static ProgressBar createProgressBar(Context paramContext, int paramInt)
  {
    Object localObject = sProgressBarCtorLock;
    try
    {
      paramContext = new ProgressBar(paramContext, null, paramInt);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  static int getStyleFromString(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("Horizontal")) {
        return 16842872;
      }
      if (paramString.equals("Small")) {
        return 16842873;
      }
      if (paramString.equals("Large")) {
        return 16842874;
      }
      if (paramString.equals("Inverse")) {
        return 16843399;
      }
      if (paramString.equals("SmallInverse")) {
        return 16843400;
      }
      if (paramString.equals("LargeInverse")) {
        return 16843401;
      }
      if (paramString.equals("Normal")) {
        return 16842871;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown ProgressBar style: ");
      localStringBuilder.append(paramString);
      throw new JSApplicationIllegalArgumentException(localStringBuilder.toString());
    }
    throw new JSApplicationIllegalArgumentException("ProgressBar needs to have a style, null received");
  }
  
  public ProgressBarShadowNode createShadowNodeInstance()
  {
    return new ProgressBarShadowNode();
  }
  
  protected ProgressBarContainerView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ProgressBarContainerView(paramThemedReactContext);
  }
  
  public String getName()
  {
    return "AndroidProgressBar";
  }
  
  public Class getShadowNodeClass()
  {
    return ProgressBarShadowNode.class;
  }
  
  protected void onAfterUpdateTransaction(ProgressBarContainerView paramProgressBarContainerView)
  {
    paramProgressBarContainerView.apply();
  }
  
  public void setAnimating(ProgressBarContainerView paramProgressBarContainerView, boolean paramBoolean)
  {
    paramProgressBarContainerView.setAnimating(paramBoolean);
  }
  
  public void setColor(ProgressBarContainerView paramProgressBarContainerView, Integer paramInteger)
  {
    paramProgressBarContainerView.setColor(paramInteger);
  }
  
  public void setIndeterminate(ProgressBarContainerView paramProgressBarContainerView, boolean paramBoolean)
  {
    paramProgressBarContainerView.setIndeterminate(paramBoolean);
  }
  
  public void setProgress(ProgressBarContainerView paramProgressBarContainerView, double paramDouble)
  {
    paramProgressBarContainerView.setProgress(paramDouble);
  }
  
  public void setStyle(ProgressBarContainerView paramProgressBarContainerView, String paramString)
  {
    paramProgressBarContainerView.setStyle(paramString);
  }
  
  public void updateExtraData(ProgressBarContainerView paramProgressBarContainerView, Object paramObject) {}
}
