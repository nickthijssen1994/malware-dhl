package com.facebook.react.uimanager.util;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R.id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ReactFindViewUtil
{
  private static final Map<OnMultipleViewsFoundListener, Set<String>> mOnMultipleViewsFoundListener = new HashMap();
  private static final List<OnViewFoundListener> mOnViewFoundListeners = new ArrayList();
  
  public ReactFindViewUtil() {}
  
  public static void addViewListener(OnViewFoundListener paramOnViewFoundListener)
  {
    mOnViewFoundListeners.add(paramOnViewFoundListener);
  }
  
  public static void addViewsListener(OnMultipleViewsFoundListener paramOnMultipleViewsFoundListener, Set paramSet)
  {
    mOnMultipleViewsFoundListener.put(paramOnMultipleViewsFoundListener, paramSet);
  }
  
  public static View findView(View paramView, String paramString)
  {
    Object localObject = getNativeId(paramView);
    if ((localObject != null) && (((String)localObject).equals(paramString))) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        localObject = findView(paramView.getChildAt(i), paramString);
        if (localObject != null) {
          return localObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static void findView(View paramView, OnViewFoundListener paramOnViewFoundListener)
  {
    paramView = findView(paramView, paramOnViewFoundListener.getNativeId());
    if (paramView != null) {
      paramOnViewFoundListener.onViewFound(paramView);
    }
    addViewListener(paramOnViewFoundListener);
  }
  
  private static String getNativeId(View paramView)
  {
    paramView = paramView.getTag(R.id.view_tag_native_id);
    if ((paramView instanceof String)) {
      return (String)paramView;
    }
    return null;
  }
  
  public static void notifyViewRendered(View paramView)
  {
    String str = getNativeId(paramView);
    if (str == null) {
      return;
    }
    Iterator localIterator = mOnViewFoundListeners.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (OnViewFoundListener)localIterator.next();
      if ((str != null) && (str.equals(((OnViewFoundListener)localObject).getNativeId())))
      {
        ((OnViewFoundListener)localObject).onViewFound(paramView);
        localIterator.remove();
      }
    }
    localIterator = mOnMultipleViewsFoundListener.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      Set localSet = (Set)((Map.Entry)localObject).getValue();
      if ((localSet != null) && (localSet.contains(str))) {
        ((OnMultipleViewsFoundListener)((Map.Entry)localObject).getKey()).onViewFound(paramView, str);
      }
    }
  }
  
  public static void removeViewListener(OnViewFoundListener paramOnViewFoundListener)
  {
    mOnViewFoundListeners.remove(paramOnViewFoundListener);
  }
  
  public static void removeViewsListener(OnMultipleViewsFoundListener paramOnMultipleViewsFoundListener)
  {
    mOnMultipleViewsFoundListener.remove(paramOnMultipleViewsFoundListener);
  }
  
  public static abstract interface OnMultipleViewsFoundListener
  {
    public abstract void onViewFound(View paramView, String paramString);
  }
  
  public static abstract interface OnViewFoundListener
  {
    public abstract String getNativeId();
    
    public abstract void onViewFound(View paramView);
  }
}
