package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;

public class AnimatableTextProperties
{
  @Nullable
  public final AnimatableColorValue color;
  @Nullable
  public final AnimatableColorValue stroke;
  @Nullable
  public final AnimatableFloatValue strokeWidth;
  @Nullable
  public final AnimatableFloatValue tracking;
  
  public AnimatableTextProperties(AnimatableColorValue paramAnimatableColorValue1, AnimatableColorValue paramAnimatableColorValue2, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2)
  {
    color = paramAnimatableColorValue1;
    stroke = paramAnimatableColorValue2;
    strokeWidth = paramAnimatableFloatValue1;
    tracking = paramAnimatableFloatValue2;
  }
}
