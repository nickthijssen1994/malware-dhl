package com.facebook.common.internal;

public class AndroidPredicates
{
  private AndroidPredicates() {}
  
  public static Predicate False()
  {
    new Predicate()
    {
      public boolean apply(Object paramAnonymousObject)
      {
        return false;
      }
    };
  }
  
  public static Predicate True()
  {
    new Predicate()
    {
      public boolean apply(Object paramAnonymousObject)
      {
        return true;
      }
    };
  }
}
