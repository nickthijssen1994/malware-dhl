package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public abstract interface Printer
{
  public abstract void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString);
  
  public abstract void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString, Object... paramVarArgs);
  
  public abstract boolean shouldDisplayLogMessage(DebugOverlayTag paramDebugOverlayTag);
}
