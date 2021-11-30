package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

public class GradientColor
{
  private final int[] colors;
  private final float[] positions;
  
  public GradientColor(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    positions = paramArrayOfFloat;
    colors = paramArrayOfInt;
  }
  
  public int[] getColors()
  {
    return colors;
  }
  
  public float[] getPositions()
  {
    return positions;
  }
  
  public int getSize()
  {
    return colors.length;
  }
  
  public void lerp(GradientColor paramGradientColor1, GradientColor paramGradientColor2, float paramFloat)
  {
    if (colors.length == colors.length)
    {
      int i = 0;
      while (i < colors.length)
      {
        positions[i] = MiscUtils.lerp(positions[i], positions[i], paramFloat);
        colors[i] = GammaEvaluator.evaluate(paramFloat, colors[i], colors[i]);
        i += 1;
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot interpolate between gradients. Lengths vary (");
    localStringBuilder.append(colors.length);
    localStringBuilder.append(" vs ");
    localStringBuilder.append(colors.length);
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}
