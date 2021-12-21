package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

class RectangleShapeParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "nm", "p", "s", "r", "hd" });
  
  private RectangleShapeParser() {}
  
  static RectangleShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    String str = null;
    AnimatableValue localAnimatableValue = null;
    AnimatablePointValue localAnimatablePointValue = null;
    AnimatableFloatValue localAnimatableFloatValue = null;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 4: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 3: 
        localAnimatableFloatValue = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
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
    return new RectangleShape(str, localAnimatableValue, localAnimatablePointValue, localAnimatableFloatValue, bool);
  }
}
