package com.facebook.react.uimanager;

import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class OnLayoutEvent
  extends Event<OnLayoutEvent>
{
  private static final Pools.SynchronizedPool<OnLayoutEvent> EVENTS_POOL = new Pools.SynchronizedPool(20);
  private int mHeight;
  private int mImageHeight;
  private int mImageWidth;
  private int mWidth;
  
  private OnLayoutEvent() {}
  
  public static OnLayoutEvent obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    OnLayoutEvent localOnLayoutEvent2 = (OnLayoutEvent)EVENTS_POOL.acquire();
    OnLayoutEvent localOnLayoutEvent1 = localOnLayoutEvent2;
    if (localOnLayoutEvent2 == null) {
      localOnLayoutEvent1 = new OnLayoutEvent();
    }
    localOnLayoutEvent1.init(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    return localOnLayoutEvent1;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    localWritableMap1.putDouble("x", PixelUtil.toDIPFromPixel(mImageWidth));
    localWritableMap1.putDouble("y", PixelUtil.toDIPFromPixel(mImageHeight));
    localWritableMap1.putDouble("width", PixelUtil.toDIPFromPixel(mWidth));
    localWritableMap1.putDouble("height", PixelUtil.toDIPFromPixel(mHeight));
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putMap("layout", localWritableMap1);
    localWritableMap2.putInt("target", getViewTag());
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), localWritableMap2);
  }
  
  public String getEventName()
  {
    return "topLayout";
  }
  
  protected void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.init(paramInt1);
    mImageWidth = paramInt2;
    mImageHeight = paramInt3;
    mWidth = paramInt4;
    mHeight = paramInt5;
  }
  
  public void onDispose()
  {
    EVENTS_POOL.release(this);
  }
}
