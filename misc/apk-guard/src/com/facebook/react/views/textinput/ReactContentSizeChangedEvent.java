package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactContentSizeChangedEvent
  extends Event<ReactTextChangedEvent>
{
  public static final String EVENT_NAME = "topContentSizeChange";
  private float mContentHeight;
  private float mContentWidth;
  
  public ReactContentSizeChangedEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    super(paramInt);
    mContentWidth = paramFloat1;
    mContentHeight = paramFloat2;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putDouble("width", mContentWidth);
    localWritableMap2.putDouble("height", mContentHeight);
    localWritableMap1.putMap("contentSize", localWritableMap2);
    localWritableMap1.putInt("target", getViewTag());
    return localWritableMap1;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public String getEventName()
  {
    return "topContentSizeChange";
  }
}
