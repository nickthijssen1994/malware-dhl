package com.airbnb.lottie.utils;

public class MeanCalculator
{
  private float _count;
  private int _total;
  
  public MeanCalculator() {}
  
  public float getMean()
  {
    int i = _total;
    if (i == 0) {
      return 0.0F;
    }
    return _count / i;
  }
  
  public void set(float paramFloat)
  {
    _count += paramFloat;
    _total += 1;
    int i = _total;
    if (i == Integer.MAX_VALUE)
    {
      _count /= 2.0F;
      _total = (i / 2);
    }
  }
}
