package com.facebook.react.devsupport;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.Queue;

public class ViewHierarchyUtil
{
  public ViewHierarchyUtil() {}
  
  public static Pair getDeepestLeaf(View paramView)
  {
    LinkedList localLinkedList = new LinkedList();
    paramView = new Pair(paramView, Integer.valueOf(1));
    localLinkedList.add(paramView);
    while (!localLinkedList.isEmpty())
    {
      Pair localPair = (Pair)localLinkedList.poll();
      Object localObject = paramView;
      if (((Integer)second).intValue() > ((Integer)second).intValue()) {
        localObject = localPair;
      }
      paramView = (View)localObject;
      if ((first instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)first;
        int j = ((Integer)second).intValue();
        int i = 0;
        for (;;)
        {
          paramView = (View)localObject;
          if (i >= localViewGroup.getChildCount()) {
            break;
          }
          localLinkedList.add(new Pair(localViewGroup.getChildAt(i), Integer.valueOf(j + 1)));
          i += 1;
        }
      }
    }
    return paramView;
  }
}
