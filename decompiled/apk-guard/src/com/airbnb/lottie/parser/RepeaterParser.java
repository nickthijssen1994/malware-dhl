package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

class RepeaterParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "nm", "c", "o", "tr", "hd" });
  
  private RepeaterParser() {}
  
  static Repeater parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    String str = null;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    AnimatableTransform localAnimatableTransform = null;
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
        localAnimatableTransform = AnimatableTransformParser.parse(paramJsonReader, paramLottieComposition);
        break;
      case 2: 
        localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 1: 
        localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 0: 
        str = paramJsonReader.nextString();
      }
    }
    return new Repeater(str, localAnimatableFloatValue2, localAnimatableFloatValue1, localAnimatableTransform, bool);
  }
}
