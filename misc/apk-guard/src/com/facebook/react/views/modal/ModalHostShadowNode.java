package com.facebook.react.views.modal;

import android.graphics.Point;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;

class ModalHostShadowNode
  extends LayoutShadowNode
{
  public ModalHostShadowNode() {}
  
  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    super.addChildAt(paramReactShadowNodeImpl, paramInt);
    Point localPoint = ModalHostHelper.getModalHostSize(getThemedContext());
    paramReactShadowNodeImpl.setStyleWidth(x);
    paramReactShadowNodeImpl.setStyleHeight(y);
  }
}
