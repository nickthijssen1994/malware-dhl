package com.facebook.react.views.swiperefresh;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class RefreshEvent
  extends Event<RefreshEvent>
{
  protected RefreshEvent(int paramInt)
  {
    super(paramInt);
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
  }
  
  public String getEventName()
  {
    return "topRefresh";
  }
}
