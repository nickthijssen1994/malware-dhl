package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JsonUtils
{
  private static final JsonReader.Options POINT_NAMES = JsonReader.Options.init(new String[] { "x", "y" });
  
  private JsonUtils() {}
  
  private static PointF jsonArrayToPoint(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    paramJsonReader.beginArray();
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.peek() != JsonReader.Token.END_ARRAY) {
      paramJsonReader.skipValue();
    }
    paramJsonReader.endArray();
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  private static PointF jsonNumbersToPoint(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.hasNext()) {
      paramJsonReader.skipValue();
    }
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  private static PointF jsonObjectToPoint(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    paramJsonReader.beginObject();
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(POINT_NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 1: 
        f1 = valueFromObject(paramJsonReader);
        break;
      case 0: 
        f2 = valueFromObject(paramJsonReader);
      }
    }
    paramJsonReader.endObject();
    return new PointF(f2 * paramFloat, f1 * paramFloat);
  }
  
  static int jsonToColor(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.beginArray();
    int i = (int)(paramJsonReader.nextDouble() * 255.0D);
    int j = (int)(paramJsonReader.nextDouble() * 255.0D);
    int k = (int)(paramJsonReader.nextDouble() * 255.0D);
    while (paramJsonReader.hasNext()) {
      paramJsonReader.skipValue();
    }
    paramJsonReader.endArray();
    return Color.argb(255, i, j, k);
  }
  
  static PointF jsonToPoint(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    switch (1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[paramJsonReader.peek().ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown point starts with ");
      localStringBuilder.append(paramJsonReader.peek());
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 3: 
      return jsonObjectToPoint(paramJsonReader, paramFloat);
    case 2: 
      return jsonArrayToPoint(paramJsonReader, paramFloat);
    }
    return jsonNumbersToPoint(paramJsonReader, paramFloat);
  }
  
  static List jsonToPoints(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.peek() == JsonReader.Token.BEGIN_ARRAY)
    {
      paramJsonReader.beginArray();
      localArrayList.add(jsonToPoint(paramJsonReader, paramFloat));
      paramJsonReader.endArray();
    }
    paramJsonReader.endArray();
    return localArrayList;
  }
  
  static float valueFromObject(JsonReader paramJsonReader)
    throws IOException
  {
    JsonReader.Token localToken = paramJsonReader.peek();
    switch (1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[localToken.ordinal()])
    {
    default: 
      paramJsonReader = new StringBuilder();
      paramJsonReader.append("Unknown value for token of type ");
      paramJsonReader.append(localToken);
      throw new IllegalArgumentException(paramJsonReader.toString());
    case 2: 
      paramJsonReader.beginArray();
      float f = (float)paramJsonReader.nextDouble();
      while (paramJsonReader.hasNext()) {
        paramJsonReader.skipValue();
      }
      paramJsonReader.endArray();
      return f;
    }
    return (float)paramJsonReader.nextDouble();
  }
}
