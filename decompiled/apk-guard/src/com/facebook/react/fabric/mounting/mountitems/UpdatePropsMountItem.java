package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdatePropsMountItem
  implements MountItem
{
  private final int mReactTag;
  private final ReadableMap mUpdatedProps;
  
  public UpdatePropsMountItem(int paramInt, ReadableMap paramReadableMap)
  {
    mReactTag = paramInt;
    mUpdatedProps = paramReadableMap;
  }
  
  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.updateProps(mReactTag, mUpdatedProps);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdatePropsMountItem [");
    localStringBuilder.append(mReactTag);
    localStringBuilder.append("] - props: ");
    localStringBuilder.append(mUpdatedProps);
    return localStringBuilder.toString();
  }
}
