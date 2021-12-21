package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;

public class TouchTargetHelper
{
  private static final float[] mEventCoords = new float[2];
  private static final Matrix mInverseMatrix = new Matrix();
  private static final float[] mMatrixTransformCoords;
  private static final PointF mTempPoint = new PointF();
  
  static
  {
    mMatrixTransformCoords = new float[2];
  }
  
  public TouchTargetHelper() {}
  
  private static View findClosestReactAncestor(View paramView)
  {
    while ((paramView != null) && (paramView.getId() <= 0)) {
      paramView = (View)paramView.getParent();
    }
    return paramView;
  }
  
  public static int findTargetTagAndCoordinatesForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    UiThreadUtil.assertOnUiThread();
    int j = paramViewGroup.getId();
    paramArrayOfFloat[0] = paramFloat1;
    paramArrayOfFloat[1] = paramFloat2;
    paramViewGroup = findTouchTargetView(paramArrayOfFloat, paramViewGroup);
    int i = j;
    if (paramViewGroup != null)
    {
      paramViewGroup = findClosestReactAncestor(paramViewGroup);
      i = j;
      if (paramViewGroup != null)
      {
        if (paramArrayOfInt != null) {
          paramArrayOfInt[0] = paramViewGroup.getId();
        }
        i = getTouchTargetForView(paramViewGroup, paramArrayOfFloat[0], paramArrayOfFloat[1]);
      }
    }
    return i;
  }
  
  public static int findTargetTagForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup)
  {
    return findTargetTagAndCoordinatesForTouch(paramFloat1, paramFloat2, paramViewGroup, mEventCoords, null);
  }
  
  public static int findTargetTagForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, int[] paramArrayOfInt)
  {
    return findTargetTagAndCoordinatesForTouch(paramFloat1, paramFloat2, paramViewGroup, mEventCoords, paramArrayOfInt);
  }
  
  private static View findTouchTargetView(float[] paramArrayOfFloat, ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount();
    ReactZIndexedViewGroup localReactZIndexedViewGroup;
    if ((paramViewGroup instanceof ReactZIndexedViewGroup)) {
      localReactZIndexedViewGroup = (ReactZIndexedViewGroup)paramViewGroup;
    } else {
      localReactZIndexedViewGroup = null;
    }
    i -= 1;
    while (i >= 0)
    {
      int j;
      if (localReactZIndexedViewGroup != null) {
        j = localReactZIndexedViewGroup.getZIndexMappedChildIndex(i);
      } else {
        j = i;
      }
      View localView = paramViewGroup.getChildAt(j);
      PointF localPointF = mTempPoint;
      if (isTransformedTouchPointInView(paramArrayOfFloat[0], paramArrayOfFloat[1], paramViewGroup, localView, localPointF))
      {
        float f1 = paramArrayOfFloat[0];
        float f2 = paramArrayOfFloat[1];
        paramArrayOfFloat[0] = x;
        paramArrayOfFloat[1] = y;
        localView = findTouchTargetViewWithPointerEvents(paramArrayOfFloat, localView);
        if (localView != null) {
          return localView;
        }
        paramArrayOfFloat[0] = f1;
        paramArrayOfFloat[1] = f2;
      }
      i -= 1;
    }
    return paramViewGroup;
  }
  
  private static View findTouchTargetViewWithPointerEvents(float[] paramArrayOfFloat, View paramView)
  {
    PointerEvents localPointerEvents;
    if ((paramView instanceof ReactPointerEventsView)) {
      localPointerEvents = ((ReactPointerEventsView)paramView).getPointerEvents();
    } else {
      localPointerEvents = PointerEvents.AUTO;
    }
    Object localObject = localPointerEvents;
    if (!paramView.isEnabled()) {
      if (localPointerEvents == PointerEvents.AUTO)
      {
        localObject = PointerEvents.BOX_NONE;
      }
      else
      {
        localObject = localPointerEvents;
        if (localPointerEvents == PointerEvents.BOX_ONLY) {
          localObject = PointerEvents.NONE;
        }
      }
    }
    if (localObject == PointerEvents.NONE) {
      return null;
    }
    if (localObject == PointerEvents.BOX_ONLY) {
      return paramView;
    }
    if (localObject == PointerEvents.BOX_NONE)
    {
      if ((paramView instanceof ViewGroup))
      {
        localObject = findTouchTargetView(paramArrayOfFloat, (ViewGroup)paramView);
        if (localObject != paramView) {
          return localObject;
        }
        if (((paramView instanceof ReactCompoundView)) && (((ReactCompoundView)paramView).reactTagForTouch(paramArrayOfFloat[0], paramArrayOfFloat[1]) != paramView.getId())) {
          return paramView;
        }
      }
      else
      {
        return null;
      }
    }
    else
    {
      if (localObject == PointerEvents.AUTO)
      {
        if (((paramView instanceof ReactCompoundViewGroup)) && (((ReactCompoundViewGroup)paramView).interceptsTouchEvent(paramArrayOfFloat[0], paramArrayOfFloat[1]))) {
          return paramView;
        }
        localObject = paramView;
        if ((paramView instanceof ViewGroup)) {
          localObject = findTouchTargetView(paramArrayOfFloat, (ViewGroup)paramView);
        }
        return localObject;
      }
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("Unknown pointer event type: ");
      paramArrayOfFloat.append(((Enum)localObject).toString());
      throw new JSApplicationIllegalArgumentException(paramArrayOfFloat.toString());
    }
    return null;
  }
  
  private static int getTouchTargetForView(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramView instanceof ReactCompoundView)) {
      return ((ReactCompoundView)paramView).reactTagForTouch(paramFloat1, paramFloat2);
    }
    return paramView.getId();
  }
  
  private static boolean isTransformedTouchPointInView(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, View paramView, PointF paramPointF)
  {
    float f1 = paramFloat1 + paramViewGroup.getScrollX() - paramView.getLeft();
    float f2 = paramFloat2 + paramViewGroup.getScrollY() - paramView.getTop();
    paramViewGroup = paramView.getMatrix();
    paramFloat2 = f1;
    paramFloat1 = f2;
    if (!paramViewGroup.isIdentity())
    {
      float[] arrayOfFloat = mMatrixTransformCoords;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f2;
      Matrix localMatrix = mInverseMatrix;
      paramViewGroup.invert(localMatrix);
      localMatrix.mapPoints(arrayOfFloat);
      paramFloat2 = arrayOfFloat[0];
      paramFloat1 = arrayOfFloat[1];
    }
    if ((paramView instanceof ReactHitSlopView))
    {
      paramViewGroup = (ReactHitSlopView)paramView;
      if (paramViewGroup.getHitSlopRect() != null)
      {
        paramViewGroup = paramViewGroup.getHitSlopRect();
        if (paramFloat2 >= -left)
        {
          if ((paramFloat2 >= paramView.getRight() - paramView.getLeft() + right) || (paramFloat1 < -top) || (paramFloat1 >= paramView.getBottom() - paramView.getTop() + bottom)) {
            break label246;
          }
          paramPointF.set(paramFloat2, paramFloat1);
          return true;
        }
        return false;
      }
    }
    if ((paramFloat2 >= 0.0F) && (paramFloat2 < paramView.getRight() - paramView.getLeft()) && (paramFloat1 >= 0.0F) && (paramFloat1 < paramView.getBottom() - paramView.getTop()))
    {
      paramPointF.set(paramFloat2, paramFloat1);
      return true;
    }
    label246:
    return false;
  }
}
