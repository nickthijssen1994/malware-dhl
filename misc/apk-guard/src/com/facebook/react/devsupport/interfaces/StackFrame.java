package com.facebook.react.devsupport.interfaces;

import org.json.JSONObject;

public abstract interface StackFrame
{
  public abstract int getColumn();
  
  public abstract String getFile();
  
  public abstract String getFileName();
  
  public abstract int getLine();
  
  public abstract String getMethod();
  
  public abstract JSONObject toJSON();
}
