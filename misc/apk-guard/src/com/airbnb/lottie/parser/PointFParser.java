package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import java.io.IOException;

public class PointFParser
  implements ValueParser<PointF>
{
  public static final PointFParser INSTANCE = new PointFParser();
  
  private PointFParser() {}
  
  public PointF parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    Object localObject = paramJsonReader.peek();
    if (localObject == JsonReader.Token.BEGIN_ARRAY) {
      return JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
    }
    if (localObject == JsonReader.Token.BEGIN_OBJECT) {
      return JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
    }
    if (localObject == JsonReader.Token.NUMBER)
    {
      localObject = new PointF((float)paramJsonReader.nextDouble() * paramFloat, (float)paramJsonReader.nextDouble() * paramFloat);
      while (paramJsonReader.hasNext()) {
        paramJsonReader.skipValue();
      }
      return localObject;
    }
    paramJsonReader = new StringBuilder();
    paramJsonReader.append("Cannot convert json to point. Next token is ");
    paramJsonReader.append(localObject);
    throw new IllegalArgumentException(paramJsonReader.toString());
  }
}
