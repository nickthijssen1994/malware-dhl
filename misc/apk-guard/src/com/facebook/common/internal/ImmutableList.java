package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList<E>
  extends ArrayList<E>
{
  private ImmutableList(int paramInt)
  {
    super(paramInt);
  }
  
  private ImmutableList(List paramList)
  {
    super(paramList);
  }
  
  public static ImmutableList copyOf(List paramList)
  {
    return new ImmutableList(paramList);
  }
  
  public static ImmutableList of(Object... paramVarArgs)
  {
    ImmutableList localImmutableList = new ImmutableList(paramVarArgs.length);
    Collections.addAll(localImmutableList, paramVarArgs);
    return localImmutableList;
  }
}
