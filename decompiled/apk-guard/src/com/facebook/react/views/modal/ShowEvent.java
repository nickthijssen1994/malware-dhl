package com.facebook.react.views.modal;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ShowEvent
  extends Event<ShowEvent>
{
  public static final String EVENT_NAME = "topShow";
  
  protected ShowEvent(int paramInt)
  {
    super(paramInt);
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
  }
  
  public String getEventName()
  {
    return "topShow";
  }
}
