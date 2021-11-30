package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

class ShapePathParser
{
  static JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "nm", "ind", "ks", "hd" });
  
  private ShapePathParser() {}
  
  static ShapePath parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    int i = 0;
    String str = null;
    AnimatableShapeValue localAnimatableShapeValue = null;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 3: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 2: 
        localAnimatableShapeValue = AnimatableValueParser.parseShapeData(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        i = paramJsonReader.nextInt();
        break;
      case 0: 
        str = paramJsonReader.nextString();
      }
    }
    return new ShapePath(str, i, localAnimatableShapeValue, bool);
  }
}
