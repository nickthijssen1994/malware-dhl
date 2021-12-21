package com.facebook.react.bridge;

import java.util.ArrayList;

public abstract interface ReadableArray
{
  public abstract ReadableArray getArray(int paramInt);
  
  public abstract boolean getBoolean(int paramInt);
  
  public abstract double getDouble(int paramInt);
  
  public abstract Dynamic getDynamic(int paramInt);
  
  public abstract int getInt(int paramInt);
  
  public abstract ReadableMap getMap(int paramInt);
  
  public abstract String getString(int paramInt);
  
  public abstract ReadableType getType(int paramInt);
  
  public abstract boolean isNull(int paramInt);
  
  public abstract int size();
  
  public abstract ArrayList toArrayList();
}
