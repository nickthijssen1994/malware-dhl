package com.facebook.common.internal;

public class Ints
{
  private Ints() {}
  
  public static int min(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 1;
    boolean bool;
    if (j > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    int k;
    for (j = paramVarArgs[0]; i < paramVarArgs.length; j = k)
    {
      k = j;
      if (paramVarArgs[i] > j) {
        k = paramVarArgs[i];
      }
      i += 1;
    }
    return j;
  }
}
