package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FontCharacterParser
{
  private static final JsonReader.Options DATA_NAMES = JsonReader.Options.init(new String[] { "shapes" });
  private static final JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "ch", "size", "w", "style", "fFamily", "data" });
  
  private FontCharacterParser() {}
  
  static FontCharacter parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginObject();
    String str2 = null;
    String str1 = null;
    double d2 = 0.0D;
    double d1 = 0.0D;
    char c = '\000';
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 5: 
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext()) {
          if (paramJsonReader.selectName(DATA_NAMES) != 0)
          {
            paramJsonReader.skipName();
            paramJsonReader.skipValue();
          }
          else
          {
            paramJsonReader.beginArray();
            while (paramJsonReader.hasNext()) {
              localArrayList.add((ShapeGroup)ContentModelParser.parse(paramJsonReader, paramLottieComposition));
            }
            paramJsonReader.endArray();
          }
        }
        paramJsonReader.endObject();
        break;
      case 4: 
        str1 = paramJsonReader.nextString();
        break;
      case 3: 
        str2 = paramJsonReader.nextString();
        break;
      case 2: 
        d1 = paramJsonReader.nextDouble();
        break;
      case 1: 
        d2 = paramJsonReader.nextDouble();
        break;
      case 0: 
        c = paramJsonReader.nextString().charAt(0);
      }
    }
    paramJsonReader.endObject();
    return new FontCharacter(localArrayList, c, d2, d1, str2, str1);
  }
}
