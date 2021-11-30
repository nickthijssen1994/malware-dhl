package com.facebook.react.uimanager.events;

import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;

public class ReactEventEmitter
  implements RCTEventEmitter
{
  private static final String PAGE_KEY = "ReactEventEmitter";
  private final SparseArray<RCTEventEmitter> mEventEmitters = new SparseArray();
  private final ReactApplicationContext mReactContext;
  
  public ReactEventEmitter(ReactApplicationContext paramReactApplicationContext)
  {
    mReactContext = paramReactApplicationContext;
  }
  
  private RCTEventEmitter getEventEmitter(int paramInt)
  {
    paramInt = ViewUtil.getUIManagerType(paramInt);
    RCTEventEmitter localRCTEventEmitter2 = (RCTEventEmitter)mEventEmitters.get(paramInt);
    RCTEventEmitter localRCTEventEmitter1 = localRCTEventEmitter2;
    if (localRCTEventEmitter2 == null) {
      localRCTEventEmitter1 = (RCTEventEmitter)mReactContext.getJSModule(RCTEventEmitter.class);
    }
    return localRCTEventEmitter1;
  }
  
  public void receiveEvent(int paramInt, String paramString, WritableMap paramWritableMap)
  {
    getEventEmitter(paramInt).receiveEvent(paramInt, paramString, paramWritableMap);
  }
  
  public void receiveTouches(String paramString, WritableArray paramWritableArray1, WritableArray paramWritableArray2)
  {
    boolean bool;
    if (paramWritableArray1.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.assertCondition(bool);
    getEventEmitter(paramWritableArray1.getMap(0).getInt("target")).receiveTouches(paramString, paramWritableArray1, paramWritableArray2);
  }
  
  public void register(int paramInt, RCTEventEmitter paramRCTEventEmitter)
  {
    mEventEmitters.put(paramInt, paramRCTEventEmitter);
  }
  
  public void unregister(int paramInt)
  {
    mEventEmitters.remove(paramInt);
  }
}
