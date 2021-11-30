package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSet<E>
  extends HashSet<E>
{
  private ImmutableSet(Set paramSet)
  {
    super(paramSet);
  }
  
  public static ImmutableSet copyOf(Set paramSet)
  {
    return new ImmutableSet(paramSet);
  }
  
  public static ImmutableSet create(Object... paramVarArgs)
  {
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return new ImmutableSet(localHashSet);
  }
}
