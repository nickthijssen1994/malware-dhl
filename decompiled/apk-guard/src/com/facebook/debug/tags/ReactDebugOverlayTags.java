package com.facebook.debug.tags;

import android.graphics.Color;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public class ReactDebugOverlayTags
{
  public static final DebugOverlayTag BRIDGE_CALLS;
  public static final DebugOverlayTag FABRIC_RECONCILER = new DebugOverlayTag("FabricReconciler", "Reconciler for Fabric", -16711681);
  public static final DebugOverlayTag FABRIC_UI_MANAGER;
  public static final DebugOverlayTag NATIVE_MODULE;
  public static final DebugOverlayTag NAVIGATION;
  public static final DebugOverlayTag PERFORMANCE = new DebugOverlayTag("Performance", "Markers for Performance", -16711936);
  public static final DebugOverlayTag RELAY = new DebugOverlayTag("Relay", "including prefetching", Color.rgb(255, 153, 0));
  public static final DebugOverlayTag RN_CORE;
  public static final DebugOverlayTag UI_MANAGER;
  
  static
  {
    NAVIGATION = new DebugOverlayTag("Navigation", "Tag for navigation", Color.rgb(156, 39, 176));
    RN_CORE = new DebugOverlayTag("RN Core", "Tag for React Native Core", -16777216);
    BRIDGE_CALLS = new DebugOverlayTag("Bridge Calls", "JS to Java calls (warning: this is spammy)", -65281);
    NATIVE_MODULE = new DebugOverlayTag("Native Module", "Native Module init", Color.rgb(128, 0, 128));
    UI_MANAGER = new DebugOverlayTag("UI Manager", "UI Manager View Operations (requires restart\nwarning: this is spammy)", -16711681);
    FABRIC_UI_MANAGER = new DebugOverlayTag("FabricUIManager", "Fabric UI Manager View Operations", -16711681);
  }
  
  public ReactDebugOverlayTags() {}
}
