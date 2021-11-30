package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingLruMap<K, V>
{
  @GuardedBy("this")
  private final LinkedHashMap<K, V> mMap = new LinkedHashMap();
  @GuardedBy("this")
  private int mSizeInBytes = 0;
  private final ValueDescriptor<V> mValueDescriptor;
  
  public CountingLruMap(ValueDescriptor paramValueDescriptor)
  {
    mValueDescriptor = paramValueDescriptor;
  }
  
  private int getValueSizeInBytes(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return mValueDescriptor.getSizeInBytes(paramObject);
  }
  
  public ArrayList clear()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(mMap.values());
      mMap.clear();
      mSizeInBytes = 0;
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    try
    {
      boolean bool = mMap.containsKey(paramObject);
      return bool;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public int getCount()
  {
    try
    {
      int i = mMap.size();
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Object getFirstKey()
  {
    try
    {
      Object localObject;
      if (mMap.isEmpty()) {
        localObject = null;
      } else {
        localObject = mMap.keySet().iterator().next();
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  ArrayList getKeys()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(mMap.keySet());
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList getMatchingEntries(Predicate paramPredicate)
  {
    try
    {
      ArrayList localArrayList = new ArrayList(mMap.entrySet().size());
      Iterator localIterator = mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate == null) || (paramPredicate.apply(localEntry.getKey()))) {
          localArrayList.add(localEntry);
        }
      }
      return localArrayList;
    }
    catch (Throwable paramPredicate)
    {
      throw paramPredicate;
    }
  }
  
  public int getSizeInBytes()
  {
    try
    {
      int i = mSizeInBytes;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  ArrayList getValues()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(mMap.values());
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Object map(Object paramObject)
  {
    try
    {
      paramObject = mMap.get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public Object remove(Object paramObject)
  {
    try
    {
      paramObject = mMap.remove(paramObject);
      mSizeInBytes -= getValueSizeInBytes(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public ArrayList removeAll(Predicate paramPredicate)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate == null) || (paramPredicate.apply(localEntry.getKey())))
        {
          localArrayList.add(localEntry.getValue());
          mSizeInBytes -= getValueSizeInBytes(localEntry.getValue());
          localIterator.remove();
        }
      }
      return localArrayList;
    }
    catch (Throwable paramPredicate)
    {
      throw paramPredicate;
    }
  }
  
  public Object removeValue(Object paramObject1, Object paramObject2)
  {
    try
    {
      Object localObject = mMap.remove(paramObject1);
      mSizeInBytes -= getValueSizeInBytes(localObject);
      mMap.put(paramObject1, paramObject2);
      mSizeInBytes += getValueSizeInBytes(paramObject2);
      return localObject;
    }
    catch (Throwable paramObject1)
    {
      throw paramObject1;
    }
  }
}
