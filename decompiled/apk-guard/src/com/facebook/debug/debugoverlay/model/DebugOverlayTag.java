package com.facebook.debug.debugoverlay.model;

import javax.annotation.concurrent.Immutable;

@Immutable
public class DebugOverlayTag
{
  public final int color;
  public final String description;
  public final String name;
  
  public DebugOverlayTag(String paramString1, String paramString2, int paramInt)
  {
    name = paramString1;
    description = paramString2;
    color = paramInt;
  }
}
