package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMap<K, V>
  extends HashMap<K, V>
{
  private ImmutableMap(Map paramMap)
  {
    super(paramMap);
  }
  
  public static ImmutableMap copyOf(Map paramMap)
  {
    return new ImmutableMap(paramMap);
  }
  
  public static Map of()
  {
    return Collections.unmodifiableMap(new HashMap());
  }
  
  public static Map of(Object paramObject1, Object paramObject2)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put(paramObject1, paramObject2);
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static Map of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put(paramObject1, paramObject2);
    localHashMap.put(paramObject3, paramObject4);
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static Map of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put(paramObject1, paramObject2);
    localHashMap.put(paramObject3, paramObject4);
    localHashMap.put(paramObject5, paramObject6);
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static Map of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put(paramObject1, paramObject2);
    localHashMap.put(paramObject3, paramObject4);
    localHashMap.put(paramObject5, paramObject6);
    localHashMap.put(paramObject7, paramObject8);
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static Map of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    HashMap localHashMap = new HashMap(5);
    localHashMap.put(paramObject1, paramObject2);
    localHashMap.put(paramObject3, paramObject4);
    localHashMap.put(paramObject5, paramObject6);
    localHashMap.put(paramObject7, paramObject8);
    localHashMap.put(paramObject9, paramObject10);
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static Map of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10, Object paramObject11, Object paramObject12)
  {
    HashMap localHashMap = new HashMap(6);
    localHashMap.put(paramObject1, paramObject2);
    localHashMap.put(paramObject3, paramObject4);
    localHashMap.put(paramObject5, paramObject6);
    localHashMap.put(paramObject7, paramObject8);
    localHashMap.put(paramObject9, paramObject10);
    localHashMap.put(paramObject11, paramObject12);
    return Collections.unmodifiableMap(localHashMap);
  }
}
