package com.facebook.react.uimanager;

import java.util.Comparator;

public class ViewAtIndex
{
  public static Comparator<ViewAtIndex> COMPARATOR = new Comparator()
  {
    public int compare(ViewAtIndex paramAnonymousViewAtIndex1, ViewAtIndex paramAnonymousViewAtIndex2)
    {
      return mIndex - mIndex;
    }
  };
  public final int mIndex;
  public final int mTag;
  
  public ViewAtIndex(int paramInt1, int paramInt2)
  {
    mTag = paramInt1;
    mIndex = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (ViewAtIndex)paramObject;
      if ((mIndex == mIndex) && (mTag == mTag)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(mTag);
    localStringBuilder.append(", ");
    localStringBuilder.append(mIndex);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
