package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public class NoopPrinter
  implements Printer
{
  public static final NoopPrinter INSTANCE = new NoopPrinter();
  
  private NoopPrinter() {}
  
  public void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString) {}
  
  public void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString, Object... paramVarArgs) {}
  
  public boolean shouldDisplayLogMessage(DebugOverlayTag paramDebugOverlayTag)
  {
    return false;
  }
}
