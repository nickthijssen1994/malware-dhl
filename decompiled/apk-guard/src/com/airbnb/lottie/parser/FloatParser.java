package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class FloatParser
  implements ValueParser<Float>
{
  public static final FloatParser INSTANCE = new FloatParser();
  
  private FloatParser() {}
  
  public Float parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    return Float.valueOf(JsonUtils.valueFromObject(paramJsonReader) * paramFloat);
  }
}
