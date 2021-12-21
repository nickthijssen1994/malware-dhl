package com.facebook.react.bridge;

public abstract interface Dynamic
{
  public abstract ReadableArray asArray();
  
  public abstract boolean asBoolean();
  
  public abstract double asDouble();
  
  public abstract int asInt();
  
  public abstract ReadableMap asMap();
  
  public abstract String asString();
  
  public abstract ReadableType getType();
  
  public abstract boolean isNull();
  
  public abstract void recycle();
}
