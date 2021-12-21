package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

class PathKeyframeParser
{
  private PathKeyframeParser() {}
  
  static PathKeyframe parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    boolean bool;
    if (paramJsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
      bool = true;
    } else {
      bool = false;
    }
    return new PathKeyframe(paramLottieComposition, KeyframeParser.parse(paramJsonReader, paramLottieComposition, Utils.dpScale(), PathParser.INSTANCE, bool));
  }
}
