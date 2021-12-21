package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class PageScrollEvent
  extends Event<PageScrollEvent>
{
  public static final String EVENT_NAME = "topPageScroll";
  private final float mOffset;
  private final int mPosition;
  
  protected PageScrollEvent(int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramInt1);
    mPosition = paramInt2;
    float f;
    if (!Float.isInfinite(paramFloat))
    {
      f = paramFloat;
      if (!Float.isNaN(paramFloat)) {}
    }
    else
    {
      f = 0.0F;
    }
    mOffset = f;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("position", mPosition);
    localWritableMap.putDouble("offset", mOffset);
    return localWritableMap;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public String getEventName()
  {
    return "topPageScroll";
  }
}
