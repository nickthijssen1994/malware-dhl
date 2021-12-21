package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

public class TouchesHelper
{
  public static final String CHANGED_TOUCHES_KEY = "changedTouches";
  private static final String LOCATION_X_KEY = "locationX";
  private static final String LOCATION_Y_KEY = "locationY";
  private static final String PAGE_X_KEY = "pageX";
  private static final String PAGE_Y_KEY = "pageY";
  private static final String POINTER_IDENTIFIER_KEY = "identifier";
  public static final String TARGET_KEY = "target";
  private static final String TIMESTAMP_KEY = "timestamp";
  public static final String TOP_TOUCH_CANCEL_KEY = "topTouchCancel";
  public static final String TOP_TOUCH_END_KEY = "topTouchEnd";
  public static final String TOUCHES_KEY = "touches";
  
  public TouchesHelper() {}
  
  private static WritableArray createsPointersArray(int paramInt, TouchEvent paramTouchEvent)
  {
    WritableArray localWritableArray = Arguments.createArray();
    MotionEvent localMotionEvent = paramTouchEvent.getMotionEvent();
    float f1 = localMotionEvent.getX();
    float f2 = paramTouchEvent.getViewX();
    float f3 = localMotionEvent.getY();
    float f4 = paramTouchEvent.getViewY();
    int i = 0;
    while (i < localMotionEvent.getPointerCount())
    {
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putDouble("pageX", PixelUtil.toDIPFromPixel(localMotionEvent.getX(i)));
      localWritableMap.putDouble("pageY", PixelUtil.toDIPFromPixel(localMotionEvent.getY(i)));
      float f5 = localMotionEvent.getX(i);
      float f6 = localMotionEvent.getY(i);
      localWritableMap.putDouble("locationX", PixelUtil.toDIPFromPixel(f5 - (f1 - f2)));
      localWritableMap.putDouble("locationY", PixelUtil.toDIPFromPixel(f6 - (f3 - f4)));
      localWritableMap.putInt("target", paramInt);
      localWritableMap.putDouble("timestamp", paramTouchEvent.getTimestampMs());
      localWritableMap.putDouble("identifier", localMotionEvent.getPointerId(i));
      localWritableArray.pushMap(localWritableMap);
      i += 1;
    }
    return localWritableArray;
  }
  
  public static void sendTouchEvent(RCTEventEmitter paramRCTEventEmitter, TouchEventType paramTouchEventType, int paramInt, TouchEvent paramTouchEvent)
  {
    WritableArray localWritableArray1 = createsPointersArray(paramInt, paramTouchEvent);
    paramTouchEvent = paramTouchEvent.getMotionEvent();
    WritableArray localWritableArray2 = Arguments.createArray();
    if ((paramTouchEventType != TouchEventType.MOVE) && (paramTouchEventType != TouchEventType.CANCEL))
    {
      if ((paramTouchEventType != TouchEventType.START) && (paramTouchEventType != TouchEventType.PENCIL))
      {
        paramRCTEventEmitter = new StringBuilder();
        paramRCTEventEmitter.append("Unknown touch type: ");
        paramRCTEventEmitter.append(paramTouchEventType);
        throw new RuntimeException(paramRCTEventEmitter.toString());
      }
      localWritableArray2.pushInt(paramTouchEvent.getActionIndex());
    }
    else
    {
      paramInt = 0;
      while (paramInt < paramTouchEvent.getPointerCount())
      {
        localWritableArray2.pushInt(paramInt);
        paramInt += 1;
      }
    }
    paramRCTEventEmitter.receiveTouches(TouchEventType.getJSEventName(paramTouchEventType), localWritableArray1, localWritableArray2);
  }
}
