package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class Font
{
  private final float ascent;
  private final String family;
  private final String name;
  private final String style;
  
  public Font(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    family = paramString1;
    name = paramString2;
    style = paramString3;
    ascent = paramFloat;
  }
  
  float getAscent()
  {
    return ascent;
  }
  
  public String getFamily()
  {
    return family;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getStyle()
  {
    return style;
  }
}
