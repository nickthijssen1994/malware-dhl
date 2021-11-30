package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;

public class InsertMountItem
  implements MountItem
{
  private int mIndex;
  private int mParentReactTag;
  private int mReactTag;
  
  public InsertMountItem(int paramInt1, int paramInt2, int paramInt3)
  {
    mReactTag = paramInt1;
    mParentReactTag = paramInt2;
    mIndex = paramInt3;
  }
  
  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.addViewAt(mParentReactTag, mReactTag, mIndex);
  }
  
  public int getIndex()
  {
    return mIndex;
  }
  
  public int getParentReactTag()
  {
    return mParentReactTag;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InsertMountItem [");
    localStringBuilder.append(mReactTag);
    localStringBuilder.append("] - parentTag: ");
    localStringBuilder.append(mParentReactTag);
    localStringBuilder.append(" - index: ");
    localStringBuilder.append(mIndex);
    return localStringBuilder.toString();
  }
}
