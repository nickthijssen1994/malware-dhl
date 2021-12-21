package com.facebook.common.internal;

public class Suppliers
{
  public static final Supplier<Boolean> BOOLEAN_FALSE = new Supplier()
  {
    public Boolean getFolder()
    {
      return Boolean.valueOf(false);
    }
  };
  public static final Supplier<Boolean> BOOLEAN_TRUE = new Supplier()
  {
    public Boolean getFolder()
    {
      return Boolean.valueOf(true);
    }
  };
  
  public Suppliers() {}
  
  public static Supplier cache(Object paramObject)
  {
    new Supplier()
    {
      public Object getFolder()
      {
        return val$instance;
      }
    };
  }
}
