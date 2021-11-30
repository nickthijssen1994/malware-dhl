package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class PageSelectedEvent
  extends Event<PageSelectedEvent>
{
  public static final String EVENT_NAME = "topPageSelected";
  private final int mPosition;
  
  protected PageSelectedEvent(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    mPosition = paramInt2;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("position", mPosition);
    return localWritableMap;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public String getEventName()
  {
    return "topPageSelected";
  }
}
