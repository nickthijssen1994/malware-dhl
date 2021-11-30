package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

class CircleShapeParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "nm", "p", "s", "hd", "d" });
  
  private CircleShapeParser() {}
  
  static CircleShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, int paramInt)
    throws IOException
  {
    boolean bool1;
    if (paramInt == 3) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    String str = null;
    AnimatableValue localAnimatableValue = null;
    AnimatablePointValue localAnimatablePointValue = null;
    boolean bool2 = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 4: 
        if (paramJsonReader.nextInt() == 3) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        break;
      case 3: 
        bool2 = paramJsonReader.nextBoolean();
        break;
      case 2: 
        localAnimatablePointValue = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        localAnimatableValue = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
        break;
      case 0: 
        str = paramJsonReader.nextString();
      }
    }
    return new CircleShape(str, localAnimatableValue, localAnimatablePointValue, bool1, bool2);
  }
}
