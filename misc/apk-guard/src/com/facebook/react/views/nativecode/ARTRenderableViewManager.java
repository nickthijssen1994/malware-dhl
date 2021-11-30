package com.facebook.react.views.nativecode;

import android.view.View;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

public class ARTRenderableViewManager
  extends ViewManager<View, ReactShadowNode>
{
  public static final String CLASS_GROUP = "ARTGroup";
  public static final String CLASS_SHAPE = "ARTShape";
  public static final String CLASS_TEXT = "ARTText";
  private final String mClassName;
  
  ARTRenderableViewManager(String paramString)
  {
    mClassName = paramString;
  }
  
  public static ARTRenderableViewManager createARTGroupViewManager()
  {
    return new ARTGroupViewManager();
  }
  
  public static ARTRenderableViewManager createARTShapeViewManager()
  {
    return new ARTShapeViewManager();
  }
  
  public static ARTRenderableViewManager createARTTextViewManager()
  {
    return new ARTTextViewManager();
  }
  
  public ReactShadowNode createShadowNodeInstance()
  {
    if ("ARTGroup".equals(mClassName)) {
      return new ARTGroupShadowNode();
    }
    if ("ARTShape".equals(mClassName)) {
      return new ARTShapeShadowNode();
    }
    if ("ARTText".equals(mClassName)) {
      return new ARTTextShadowNode();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected type ");
    localStringBuilder.append(mClassName);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  protected View createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    throw new IllegalStateException("ARTShape does not map into a native view");
  }
  
  public String getName()
  {
    return mClassName;
  }
  
  public Class getShadowNodeClass()
  {
    if ("ARTGroup".equals(mClassName)) {
      return com.facebook.react.views.art.ARTGroupShadowNode.class;
    }
    if ("ARTShape".equals(mClassName)) {
      return com.facebook.react.views.art.ARTShapeShadowNode.class;
    }
    if ("ARTText".equals(mClassName)) {
      return com.facebook.react.views.art.ARTTextShadowNode.class;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected type ");
    localStringBuilder.append(mClassName);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void updateExtraData(View paramView, Object paramObject)
  {
    throw new IllegalStateException("ARTShape does not map into a native view");
  }
}
