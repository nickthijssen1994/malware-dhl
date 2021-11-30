package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactSliderEvent
  extends Event<ReactSliderEvent>
{
  public static final String EVENT_NAME = "topChange";
  private final boolean mFromUser;
  private final double mValue;
  
  public ReactSliderEvent(int paramInt, double paramDouble, boolean paramBoolean)
  {
    super(paramInt);
    mValue = paramDouble;
    mFromUser = paramBoolean;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("target", getViewTag());
    localWritableMap.putDouble("value", getValue());
    localWritableMap.putBoolean("fromUser", isFromUser());
    return localWritableMap;
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
    return "topChange";
  }
  
  public double getValue()
  {
    return mValue;
  }
  
  public boolean isFromUser()
  {
    return mFromUser;
  }
}
