package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class PageScrollStateChangedEvent
  extends Event<PageScrollStateChangedEvent>
{
  public static final String EVENT_NAME = "topPageScrollStateChanged";
  private final String mPageScrollState;
  
  protected PageScrollStateChangedEvent(int paramInt, String paramString)
  {
    super(paramInt);
    mPageScrollState = paramString;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("pageScrollState", mPageScrollState);
    return localWritableMap;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public String getEventName()
  {
    return "topPageScrollStateChanged";
  }
}
