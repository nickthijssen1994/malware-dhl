package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ReactTextInputFocusEvent
  extends Event<ReactTextInputFocusEvent>
{
  private static final String EVENT_NAME = "topFocus";
  
  public ReactTextInputFocusEvent(int paramInt)
  {
    super(paramInt);
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("target", getViewTag());
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
  
  public String getEventName()
  {
    return "topFocus";
  }
}
