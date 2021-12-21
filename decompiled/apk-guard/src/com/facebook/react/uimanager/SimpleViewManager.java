package com.facebook.react.uimanager;

import android.view.View;

public abstract class SimpleViewManager<T extends View>
  extends BaseViewManager<T, LayoutShadowNode>
{
  public SimpleViewManager() {}
  
  public LayoutShadowNode createShadowNodeInstance()
  {
    return new LayoutShadowNode();
  }
  
  public Class getShadowNodeClass()
  {
    return LayoutShadowNode.class;
  }
  
  public void updateExtraData(View paramView, Object paramObject) {}
}
