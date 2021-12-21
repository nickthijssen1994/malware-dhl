package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextInputEvent
  extends Event<ReactTextInputEvent>
{
  public static final String EVENT_NAME = "topTextInput";
  private String mPreviousText;
  private int mRangeEnd;
  private int mRangeStart;
  private String mText;
  
  public ReactTextInputEvent(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    mText = paramString1;
    mPreviousText = paramString2;
    mRangeStart = paramInt2;
    mRangeEnd = paramInt3;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putDouble("start", mRangeStart);
    localWritableMap2.putDouble("end", mRangeEnd);
    localWritableMap1.putString("text", mText);
    localWritableMap1.putString("previousText", mPreviousText);
    localWritableMap1.putMap("range", localWritableMap2);
    localWritableMap1.putInt("target", getViewTag());
    return localWritableMap1;
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
    return "topTextInput";
  }
}
