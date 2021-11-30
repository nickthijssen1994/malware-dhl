package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class IntegerParser
  implements ValueParser<Integer>
{
  public static final IntegerParser INSTANCE = new IntegerParser();
  
  private IntegerParser() {}
  
  public Integer parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    return Integer.valueOf(Math.round(JsonUtils.valueFromObject(paramJsonReader) * paramFloat));
  }
}
