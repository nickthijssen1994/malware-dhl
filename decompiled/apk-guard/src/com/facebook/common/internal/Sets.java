package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class Sets
{
  private Sets() {}
  
  public static CopyOnWriteArraySet newCopyOnWriteArraySet()
  {
    return new CopyOnWriteArraySet();
  }
  
  public static HashSet newHashSet()
  {
    return new HashSet();
  }
  
  public static HashSet newHashSet(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new HashSet((Collection)paramIterable);
    }
    return newHashSet(paramIterable.iterator());
  }
  
  public static HashSet newHashSet(Iterator paramIterator)
  {
    HashSet localHashSet = newHashSet();
    while (paramIterator.hasNext()) {
      localHashSet.add(paramIterator.next());
    }
    return localHashSet;
  }
  
  public static HashSet newHashSet(Object... paramVarArgs)
  {
    HashSet localHashSet = newHashSetWithCapacity(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return localHashSet;
  }
  
  public static HashSet newHashSetWithCapacity(int paramInt)
  {
    return new HashSet(paramInt);
  }
  
  public static Set newIdentityHashSet()
  {
    return newSetFromMap(new IdentityHashMap());
  }
  
  public static LinkedHashSet newLinkedHashSet()
  {
    return new LinkedHashSet();
  }
  
  public static Set newSetFromMap(Map paramMap)
  {
    return Collections.newSetFromMap(paramMap);
  }
}
