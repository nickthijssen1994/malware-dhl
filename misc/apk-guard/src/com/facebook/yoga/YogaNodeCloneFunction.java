package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface YogaNodeCloneFunction
{
  public abstract YogaNode cloneNode(YogaNode paramYogaNode1, YogaNode paramYogaNode2, int paramInt);
}
