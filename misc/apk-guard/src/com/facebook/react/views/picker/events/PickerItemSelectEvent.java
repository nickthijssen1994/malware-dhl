package com.facebook.react.views.picker.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class PickerItemSelectEvent
  extends Event<PickerItemSelectEvent>
{
  public static final String EVENT_NAME = "topSelect";
  private final int mPosition;
  
  public PickerItemSelectEvent(int paramInt1, int paramInt2)
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
    return "topSelect";
  }
}
