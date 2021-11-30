package com.airbnb.lottie.value;

public class LottieFrameInfo<T>
{
  private float endFrame;
  private T endValue;
  private float interpolatedKeyframeProgress;
  private float linearKeyframeProgress;
  private float overallProgress;
  private float startFrame;
  private T startValue;
  
  public LottieFrameInfo() {}
  
  public float getEndFrame()
  {
    return endFrame;
  }
  
  public Object getEndValue()
  {
    return endValue;
  }
  
  public float getInterpolatedKeyframeProgress()
  {
    return interpolatedKeyframeProgress;
  }
  
  public float getLinearKeyframeProgress()
  {
    return linearKeyframeProgress;
  }
  
  public float getOverallProgress()
  {
    return overallProgress;
  }
  
  public float getStartFrame()
  {
    return startFrame;
  }
  
  public Object getStartValue()
  {
    return startValue;
  }
  
  public LottieFrameInfo map(float paramFloat1, float paramFloat2, Object paramObject1, Object paramObject2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    startFrame = paramFloat1;
    endFrame = paramFloat2;
    startValue = paramObject1;
    endValue = paramObject2;
    linearKeyframeProgress = paramFloat3;
    interpolatedKeyframeProgress = paramFloat4;
    overallProgress = paramFloat5;
    return this;
  }
}
