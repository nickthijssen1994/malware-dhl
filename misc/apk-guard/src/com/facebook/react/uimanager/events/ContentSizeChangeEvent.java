package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

public class ContentSizeChangeEvent
  extends Event<ContentSizeChangeEvent>
{
  public static final String EVENT_NAME = "topContentSizeChange";
  private final int mHeight;
  private final int mWidth;
  
  public ContentSizeChangeEvent(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    mWidth = paramInt2;
    mHeight = paramInt3;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putDouble("width", PixelUtil.toDIPFromPixel(mWidth));
    localWritableMap.putDouble("height", PixelUtil.toDIPFromPixel(mHeight));
    paramRCTEventEmitter.receiveEvent(getViewTag(), "topContentSizeChange", localWritableMap);
  }
  
  public String getEventName()
  {
    return "topContentSizeChange";
  }
}
