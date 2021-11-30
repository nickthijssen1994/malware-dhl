package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextInputKeyPressEvent
  extends Event<ReactTextInputEvent>
{
  public static final String EVENT_NAME = "topKeyPress";
  private String mKey;
  
  ReactTextInputKeyPressEvent(int paramInt, String paramString)
  {
    super(paramInt);
    mKey = paramString;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("key", mKey);
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
    return "topKeyPress";
  }
}
