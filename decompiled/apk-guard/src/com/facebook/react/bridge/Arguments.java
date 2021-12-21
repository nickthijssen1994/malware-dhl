package com.facebook.react.bridge;

import android.os.BaseBundle;
import android.os.Bundle;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Arguments
{
  public Arguments() {}
  
  private static void addEntry(WritableNativeMap paramWritableNativeMap, String paramString, Object paramObject)
  {
    paramObject = makeNativeObject(paramObject);
    if (paramObject == null)
    {
      paramWritableNativeMap.putNull(paramString);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramWritableNativeMap.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramWritableNativeMap.putInt(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Number))
    {
      paramWritableNativeMap.putDouble(paramString, ((Number)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramWritableNativeMap.putString(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof WritableNativeArray))
    {
      paramWritableNativeMap.putArray(paramString, (WritableNativeArray)paramObject);
      return;
    }
    if ((paramObject instanceof WritableNativeMap))
    {
      paramWritableNativeMap.putMap(paramString, (WritableNativeMap)paramObject);
      return;
    }
    paramWritableNativeMap = new StringBuilder();
    paramWritableNativeMap.append("Could not convert ");
    paramWritableNativeMap.append(paramObject.getClass());
    throw new IllegalArgumentException(paramWritableNativeMap.toString());
  }
  
  public static WritableArray createArray()
  {
    return new WritableNativeArray();
  }
  
  public static WritableMap createMap()
  {
    return new WritableNativeMap();
  }
  
  public static WritableArray fromArray(Object paramObject)
  {
    Object localObject = createArray();
    boolean bool = paramObject instanceof String[];
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (String[])paramObject;
      j = paramObject.length;
      while (i < j)
      {
        ((WritableArray)localObject).pushString(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramObject = (Bundle[])paramObject;
      k = paramObject.length;
      i = j;
      while (i < k)
      {
        ((WritableArray)localObject).pushMap(fromBundle(paramObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])paramObject;
      j = paramObject.length;
      i = k;
      while (i < j)
      {
        ((WritableArray)localObject).pushInt(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])paramObject;
      j = paramObject.length;
      i = m;
      while (i < j)
      {
        ((WritableArray)localObject).pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (double[])paramObject;
      j = paramObject.length;
      i = n;
      while (i < j)
      {
        ((WritableArray)localObject).pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (boolean[])paramObject;
      j = paramObject.length;
      i = i1;
      while (i < j)
      {
        ((WritableArray)localObject).pushBoolean(paramObject[i]);
        i += 1;
      }
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown array type ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    return localObject;
  }
  
  public static WritableMap fromBundle(Bundle paramBundle)
  {
    WritableMap localWritableMap = createMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (localObject == null)
      {
        localWritableMap.putNull(str);
      }
      else if (localObject.getClass().isArray())
      {
        localWritableMap.putArray(str, fromArray(localObject));
      }
      else if ((localObject instanceof String))
      {
        localWritableMap.putString(str, (String)localObject);
      }
      else if ((localObject instanceof Number))
      {
        if ((localObject instanceof Integer)) {
          localWritableMap.putInt(str, ((Integer)localObject).intValue());
        } else {
          localWritableMap.putDouble(str, ((Number)localObject).doubleValue());
        }
      }
      else if ((localObject instanceof Boolean))
      {
        localWritableMap.putBoolean(str, ((Boolean)localObject).booleanValue());
      }
      else if ((localObject instanceof Bundle))
      {
        localWritableMap.putMap(str, fromBundle((Bundle)localObject));
      }
      else if ((localObject instanceof List))
      {
        localWritableMap.putArray(str, fromList((List)localObject));
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append("Could not convert ");
        paramBundle.append(localObject.getClass());
        throw new IllegalArgumentException(paramBundle.toString());
      }
    }
    return localWritableMap;
  }
  
  public static WritableNativeArray fromJavaArgs(Object[] paramArrayOfObject)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      Class localClass;
      if (localObject == null)
      {
        localWritableNativeArray.pushNull();
      }
      else
      {
        localClass = localObject.getClass();
        if (localClass == Boolean.class)
        {
          localWritableNativeArray.pushBoolean(((Boolean)localObject).booleanValue());
        }
        else if (localClass == Integer.class)
        {
          localWritableNativeArray.pushDouble(((Integer)localObject).doubleValue());
        }
        else if (localClass == Double.class)
        {
          localWritableNativeArray.pushDouble(((Double)localObject).doubleValue());
        }
        else if (localClass == Float.class)
        {
          localWritableNativeArray.pushDouble(((Float)localObject).doubleValue());
        }
        else if (localClass == String.class)
        {
          localWritableNativeArray.pushString(localObject.toString());
        }
        else if (localClass == WritableNativeMap.class)
        {
          localWritableNativeArray.pushMap((WritableNativeMap)localObject);
        }
        else
        {
          if (localClass != WritableNativeArray.class) {
            break label181;
          }
          localWritableNativeArray.pushArray((WritableNativeArray)localObject);
        }
      }
      i += 1;
      continue;
      label181:
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("Cannot convert argument of type ");
      paramArrayOfObject.append(localClass);
      throw new RuntimeException(paramArrayOfObject.toString());
    }
    return localWritableNativeArray;
  }
  
  public static WritableArray fromList(List paramList)
  {
    Object localObject = createArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (paramList == null)
      {
        ((WritableArray)localObject).pushNull();
      }
      else if (paramList.getClass().isArray())
      {
        ((WritableArray)localObject).pushArray(fromArray(paramList));
      }
      else if ((paramList instanceof Bundle))
      {
        ((WritableArray)localObject).pushMap(fromBundle((Bundle)paramList));
      }
      else if ((paramList instanceof List))
      {
        ((WritableArray)localObject).pushArray(fromList((List)paramList));
      }
      else if ((paramList instanceof String))
      {
        ((WritableArray)localObject).pushString((String)paramList);
      }
      else if ((paramList instanceof Integer))
      {
        ((WritableArray)localObject).pushInt(((Integer)paramList).intValue());
      }
      else if ((paramList instanceof Number))
      {
        ((WritableArray)localObject).pushDouble(((Number)paramList).doubleValue());
      }
      else if ((paramList instanceof Boolean))
      {
        ((WritableArray)localObject).pushBoolean(((Boolean)paramList).booleanValue());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown value type ");
        ((StringBuilder)localObject).append(paramList.getClass());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    return localObject;
  }
  
  public static WritableNativeArray makeNativeArray(Object paramObject)
  {
    if (paramObject == null) {
      return new WritableNativeArray();
    }
    makeNativeArray(new AbstractList()
    {
      public Object get(int paramAnonymousInt)
      {
        return Array.get(val$objects, paramAnonymousInt);
      }
      
      public int size()
      {
        return Array.getLength(val$objects);
      }
    });
  }
  
  public static WritableNativeArray makeNativeArray(List paramList)
  {
    Object localObject = new WritableNativeArray();
    if (paramList == null) {
      return localObject;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = makeNativeObject(localIterator.next());
      if (paramList == null)
      {
        ((WritableNativeArray)localObject).pushNull();
      }
      else if ((paramList instanceof Boolean))
      {
        ((WritableNativeArray)localObject).pushBoolean(((Boolean)paramList).booleanValue());
      }
      else if ((paramList instanceof Integer))
      {
        ((WritableNativeArray)localObject).pushInt(((Integer)paramList).intValue());
      }
      else if ((paramList instanceof Double))
      {
        ((WritableNativeArray)localObject).pushDouble(((Double)paramList).doubleValue());
      }
      else if ((paramList instanceof String))
      {
        ((WritableNativeArray)localObject).pushString((String)paramList);
      }
      else if ((paramList instanceof WritableNativeArray))
      {
        ((WritableNativeArray)localObject).pushArray((WritableNativeArray)paramList);
      }
      else if ((paramList instanceof WritableNativeMap))
      {
        ((WritableNativeArray)localObject).pushMap((WritableNativeMap)paramList);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Could not convert ");
        ((StringBuilder)localObject).append(paramList.getClass());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    return localObject;
  }
  
  public static WritableNativeMap makeNativeMap(Bundle paramBundle)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (paramBundle == null) {
      return localWritableNativeMap;
    }
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      addEntry(localWritableNativeMap, str, paramBundle.get(str));
    }
    return localWritableNativeMap;
  }
  
  public static WritableNativeMap makeNativeMap(Map paramMap)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (paramMap == null) {
      return localWritableNativeMap;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      addEntry(localWritableNativeMap, (String)localEntry.getKey(), localEntry.getValue());
    }
    return localWritableNativeMap;
  }
  
  private static Object makeNativeObject(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((!(paramObject instanceof Float)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Short)))
    {
      if (paramObject.getClass().isArray()) {
        return makeNativeArray(paramObject);
      }
      if ((paramObject instanceof List)) {
        return makeNativeArray((List)paramObject);
      }
      if ((paramObject instanceof Map)) {
        return makeNativeMap((Map)paramObject);
      }
      if ((paramObject instanceof Bundle)) {
        return makeNativeMap((Bundle)paramObject);
      }
      return paramObject;
    }
    return Double.valueOf(((Number)paramObject).doubleValue());
  }
  
  public static Bundle toBundle(ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null) {
      return null;
    }
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
    Bundle localBundle = new Bundle();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      ReadableType localReadableType = paramReadableMap.getType(str);
      switch (2.$SwitchMap$com$facebook$react$bridge$ReadableType[localReadableType.ordinal()])
      {
      default: 
        paramReadableMap = new StringBuilder();
        paramReadableMap.append("Could not convert object with key: ");
        paramReadableMap.append(str);
        paramReadableMap.append(".");
        throw new IllegalArgumentException(paramReadableMap.toString());
      case 6: 
        localBundle.putSerializable(str, toList(paramReadableMap.getArray(str)));
        break;
      case 5: 
        localBundle.putBundle(str, toBundle(paramReadableMap.getMap(str)));
        break;
      case 4: 
        localBundle.putString(str, paramReadableMap.getString(str));
        break;
      case 3: 
        localBundle.putDouble(str, paramReadableMap.getDouble(str));
        break;
      case 2: 
        localBundle.putBoolean(str, paramReadableMap.getBoolean(str));
        break;
      case 1: 
        localBundle.putString(str, null);
      }
    }
    return localBundle;
  }
  
  public static ArrayList toList(ReadableArray paramReadableArray)
  {
    if (paramReadableArray == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramReadableArray.size())
    {
      switch (2.$SwitchMap$com$facebook$react$bridge$ReadableType[paramReadableArray.getType(i).ordinal()])
      {
      default: 
        throw new IllegalArgumentException("Could not convert object in array.");
      case 6: 
        localArrayList.add(toList(paramReadableArray.getArray(i)));
        break;
      case 5: 
        localArrayList.add(toBundle(paramReadableArray.getMap(i)));
        break;
      case 4: 
        localArrayList.add(paramReadableArray.getString(i));
        break;
      case 3: 
        double d = paramReadableArray.getDouble(i);
        if (d == Math.rint(d)) {
          localArrayList.add(Integer.valueOf((int)d));
        } else {
          localArrayList.add(Double.valueOf(d));
        }
        break;
      case 2: 
        localArrayList.add(Boolean.valueOf(paramReadableArray.getBoolean(i)));
        break;
      case 1: 
        localArrayList.add(null);
      }
      i += 1;
    }
    return localArrayList;
  }
}
