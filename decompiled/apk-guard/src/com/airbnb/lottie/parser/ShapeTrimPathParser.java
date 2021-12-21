package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

class ShapeTrimPathParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "s", "e", "o", "nm", "m", "hd" });
  
  private ShapeTrimPathParser() {}
  
  static ShapeTrimPath parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    String str = null;
    ShapeTrimPath.Type localType = null;
    AnimatableFloatValue localAnimatableFloatValue3 = null;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 5: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 4: 
        localType = ShapeTrimPath.Type.forId(paramJsonReader.nextInt());
        break;
      case 3: 
        str = paramJsonReader.nextString();
        break;
      case 2: 
        localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 1: 
        localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 0: 
        localAnimatableFloatValue3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      }
    }
    return new ShapeTrimPath(str, localType, localAnimatableFloatValue3, localAnimatableFloatValue2, localAnimatableFloatValue1, bool);
  }
}
