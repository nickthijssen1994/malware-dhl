package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;

public class MultiDraweeHolder<DH extends DraweeHierarchy>
{
  @VisibleForTesting
  ArrayList<DraweeHolder<DH>> mHolders = new ArrayList();
  @VisibleForTesting
  boolean mIsAttached = false;
  
  public MultiDraweeHolder() {}
  
  public DraweeHolder calculateDimensions(int paramInt)
  {
    return (DraweeHolder)mHolders.get(paramInt);
  }
  
  public void clear()
  {
    if (mIsAttached)
    {
      int i = 0;
      while (i < mHolders.size())
      {
        ((DraweeHolder)mHolders.get(i)).onDetach();
        i += 1;
      }
    }
    mHolders.clear();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < mHolders.size())
    {
      Drawable localDrawable = calculateDimensions(i).getTopLevelDrawable();
      if (localDrawable != null) {
        localDrawable.draw(paramCanvas);
      }
      i += 1;
    }
  }
  
  public void onAttach()
  {
    if (mIsAttached) {
      return;
    }
    mIsAttached = true;
    int i = 0;
    while (i < mHolders.size())
    {
      ((DraweeHolder)mHolders.get(i)).onAttach();
      i += 1;
    }
  }
  
  public void onDetach()
  {
    if (!mIsAttached) {
      return;
    }
    int i = 0;
    mIsAttached = false;
    while (i < mHolders.size())
    {
      ((DraweeHolder)mHolders.get(i)).onDetach();
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < mHolders.size())
    {
      if (((DraweeHolder)mHolders.get(i)).onTouchEvent(paramMotionEvent)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void remove(int paramInt)
  {
    DraweeHolder localDraweeHolder = (DraweeHolder)mHolders.get(paramInt);
    if (mIsAttached) {
      localDraweeHolder.onDetach();
    }
    mHolders.remove(paramInt);
  }
  
  public void replaceComment(DraweeHolder paramDraweeHolder)
  {
    set(mHolders.size(), paramDraweeHolder);
  }
  
  public void set(int paramInt, DraweeHolder paramDraweeHolder)
  {
    Preconditions.checkNotNull(paramDraweeHolder);
    Preconditions.checkElementIndex(paramInt, mHolders.size() + 1);
    mHolders.add(paramInt, paramDraweeHolder);
    if (mIsAttached) {
      paramDraweeHolder.onAttach();
    }
  }
  
  public int size()
  {
    return mHolders.size();
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    int i = 0;
    while (i < mHolders.size())
    {
      if (paramDrawable == calculateDimensions(i).getTopLevelDrawable()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}
