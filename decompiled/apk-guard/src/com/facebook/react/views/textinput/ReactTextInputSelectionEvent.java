package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ReactTextInputSelectionEvent
  extends Event<ReactTextInputSelectionEvent>
{
  private static final String EVENT_NAME = "topSelectionChange";
  private int mSelectionEnd;
  private int mSelectionStart;
  
  public ReactTextInputSelectionEvent(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    mSelectionStart = paramInt2;
    mSelectionEnd = paramInt3;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putInt("end", mSelectionEnd);
    localWritableMap2.putInt("start", mSelectionStart);
    localWritableMap1.putMap("selection", localWritableMap2);
    return localWritableMap1;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public String getEventName()
  {
    return "topSelectionChange";
  }
}
