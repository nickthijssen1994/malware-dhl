package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;

public class DeleteMountItem
  implements MountItem
{
  private int mReactTag;
  
  public DeleteMountItem(int paramInt)
  {
    mReactTag = paramInt;
  }
  
  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.deleteView(mReactTag);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeleteMountItem [");
    localStringBuilder.append(mReactTag);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
