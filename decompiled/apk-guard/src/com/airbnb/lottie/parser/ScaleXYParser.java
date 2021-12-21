package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class ScaleXYParser
  implements ValueParser<ScaleXY>
{
  public static final ScaleXYParser INSTANCE = new ScaleXYParser();
  
  private ScaleXYParser() {}
  
  public ScaleXY parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    int i;
    if (paramJsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramJsonReader.beginArray();
    }
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.hasNext()) {
      paramJsonReader.skipValue();
    }
    if (i != 0) {
      paramJsonReader.endArray();
    }
    return new ScaleXY(f1 / 100.0F * paramFloat, f2 / 100.0F * paramFloat);
  }
}
