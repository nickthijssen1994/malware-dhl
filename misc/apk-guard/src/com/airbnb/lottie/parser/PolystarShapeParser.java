package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

class PolystarShapeParser
{
  private static final JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd" });
  
  private PolystarShapeParser() {}
  
  static PolystarShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    String str = null;
    PolystarShape.Type localType = null;
    AnimatableFloatValue localAnimatableFloatValue6 = null;
    AnimatableValue localAnimatableValue = null;
    AnimatableFloatValue localAnimatableFloatValue5 = null;
    AnimatableFloatValue localAnimatableFloatValue4 = null;
    AnimatableFloatValue localAnimatableFloatValue3 = null;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 9: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 8: 
        localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 7: 
        localAnimatableFloatValue4 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 6: 
        localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 5: 
        localAnimatableFloatValue3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 4: 
        localAnimatableFloatValue5 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 3: 
        localAnimatableValue = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
        break;
      case 2: 
        localAnimatableFloatValue6 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 1: 
        localType = PolystarShape.Type.forValue(paramJsonReader.nextInt());
        break;
      case 0: 
        str = paramJsonReader.nextString();
      }
    }
    return new PolystarShape(str, localType, localAnimatableFloatValue6, localAnimatableValue, localAnimatableFloatValue5, localAnimatableFloatValue4, localAnimatableFloatValue3, localAnimatableFloatValue2, localAnimatableFloatValue1, bool);
  }
}
