package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class FontCharacter
{
  private final char character;
  private final String fontFamily;
  private final List<ShapeGroup> shapes;
  private final double size;
  private final String style;
  private final double width;
  
  public FontCharacter(List paramList, char paramChar, double paramDouble1, double paramDouble2, String paramString1, String paramString2)
  {
    shapes = paramList;
    character = paramChar;
    size = paramDouble1;
    width = paramDouble2;
    style = paramString1;
    fontFamily = paramString2;
  }
  
  public static int hashFor(char paramChar, String paramString1, String paramString2)
  {
    return (('\000' + paramChar) * 31 + paramString1.hashCode()) * 31 + paramString2.hashCode();
  }
  
  public List getShapes()
  {
    return shapes;
  }
  
  double getSize()
  {
    return size;
  }
  
  String getStyle()
  {
    return style;
  }
  
  public double getWidth()
  {
    return width;
  }
  
  public int hashCode()
  {
    return hashFor(character, fontFamily, style);
  }
}
