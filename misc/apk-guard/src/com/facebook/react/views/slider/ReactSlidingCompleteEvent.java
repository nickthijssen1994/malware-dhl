package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactSlidingCompleteEvent
  extends Event<ReactSlidingCompleteEvent>
{
  public static final String EVENT_NAME = "topSlidingComplete";
  private final double mValue;
  
  public ReactSlidingCompleteEvent(int paramInt, double paramDouble)
  {
    super(paramInt);
    mValue = paramDouble;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("target", getViewTag());
    localWritableMap.putDouble("value", getValue());
    return localWritableMap;
  }
  
  public boolean canCoalesce()
  {
    return false;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public short getCoalescingKey()
  {
    return 0;
  }
  
  public String getEventName()
  {
    return "topSlidingComplete";
  }
  
  public double getValue()
  {
    return mValue;
  }
}
