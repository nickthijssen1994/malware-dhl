package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.HashSet;
import java.util.Set;

public class ProgressBarShadowNode
  extends LayoutShadowNode
  implements YogaMeasureFunction
{
  private final SparseIntArray mHeight = new SparseIntArray();
  private final Set<Integer> mMeasured = new HashSet();
  private String mStyle = "Normal";
  private final SparseIntArray mWidth = new SparseIntArray();
  
  public ProgressBarShadowNode()
  {
    initMeasureFunction();
  }
  
  private void initMeasureFunction()
  {
    setMeasureFunction(this);
  }
  
  public String getStyle()
  {
    return mStyle;
  }
  
  public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    int i = ReactProgressBarViewManager.getStyleFromString(getStyle());
    if (!mMeasured.contains(Integer.valueOf(i)))
    {
      paramYogaNode = ReactProgressBarViewManager.createProgressBar(getThemedContext(), i);
      int j = View.MeasureSpec.makeMeasureSpec(-2, 0);
      paramYogaNode.measure(j, j);
      mHeight.put(i, paramYogaNode.getMeasuredHeight());
      mWidth.put(i, paramYogaNode.getMeasuredWidth());
      mMeasured.add(Integer.valueOf(i));
    }
    return YogaMeasureOutput.make(mWidth.get(i), mHeight.get(i));
  }
  
  public void setStyle(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "Normal";
    }
    mStyle = str;
  }
}
