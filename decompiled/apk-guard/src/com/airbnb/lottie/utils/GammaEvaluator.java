package com.airbnb.lottie.utils;

public class GammaEvaluator
{
  public GammaEvaluator() {}
  
  private static float EOCF_sRGB(float paramFloat)
  {
    if (paramFloat <= 0.04045F) {
      return paramFloat / 12.92F;
    }
    return (float)Math.pow((paramFloat + 0.055F) / 1.055F, 2.4000000953674316D);
  }
  
  private static float OECF_sRGB(float paramFloat)
  {
    if (paramFloat <= 0.0031308F) {
      return paramFloat * 12.92F;
    }
    return (float)(Math.pow(paramFloat, 0.4166666567325592D) * 1.0549999475479126D - 0.054999999701976776D);
  }
  
  public static int evaluate(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return paramInt1;
    }
    float f1 = (paramInt1 >> 24 & 0xFF) / 255.0F;
    float f4 = (paramInt1 >> 16 & 0xFF) / 255.0F;
    float f5 = (paramInt1 >> 8 & 0xFF) / 255.0F;
    float f6 = (paramInt1 & 0xFF) / 255.0F;
    float f2 = (paramInt2 >> 24 & 0xFF) / 255.0F;
    float f8 = (paramInt2 >> 16 & 0xFF) / 255.0F;
    float f7 = (paramInt2 >> 8 & 0xFF) / 255.0F;
    float f3 = (paramInt2 & 0xFF) / 255.0F;
    f4 = EOCF_sRGB(f4);
    f5 = EOCF_sRGB(f5);
    f6 = EOCF_sRGB(f6);
    f8 = EOCF_sRGB(f8);
    f7 = EOCF_sRGB(f7);
    f3 = EOCF_sRGB(f3);
    f4 = OECF_sRGB(f4 + (f8 - f4) * paramFloat);
    f5 = OECF_sRGB(f5 + (f7 - f5) * paramFloat);
    f3 = OECF_sRGB(f6 + paramFloat * (f3 - f6));
    paramInt1 = Math.round((f1 + (f2 - f1) * paramFloat) * 255.0F);
    return Math.round(f4 * 255.0F) << 16 | paramInt1 << 24 | Math.round(f5 * 255.0F) << 8 | Math.round(f3 * 255.0F);
  }
}
