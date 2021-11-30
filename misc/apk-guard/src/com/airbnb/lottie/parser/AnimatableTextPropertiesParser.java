package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

public class AnimatableTextPropertiesParser
{
  private static JsonReader.Options ANIMATABLE_PROPERTIES_NAMES = JsonReader.Options.init(new String[] { "fc", "sc", "sw", "t" });
  private static JsonReader.Options PROPERTIES_NAMES = JsonReader.Options.init(new String[] { "a" });
  
  private AnimatableTextPropertiesParser() {}
  
  public static AnimatableTextProperties parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    paramJsonReader.beginObject();
    AnimatableTextProperties localAnimatableTextProperties = null;
    while (paramJsonReader.hasNext()) {
      if (paramJsonReader.selectName(PROPERTIES_NAMES) != 0)
      {
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
      }
      else
      {
        localAnimatableTextProperties = parseAnimatableTextProperties(paramJsonReader, paramLottieComposition);
      }
    }
    paramJsonReader.endObject();
    paramJsonReader = localAnimatableTextProperties;
    if (localAnimatableTextProperties == null) {
      paramJsonReader = new AnimatableTextProperties(null, null, null, null);
    }
    return paramJsonReader;
  }
  
  private static AnimatableTextProperties parseAnimatableTextProperties(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    paramJsonReader.beginObject();
    AnimatableColorValue localAnimatableColorValue2 = null;
    AnimatableColorValue localAnimatableColorValue1 = null;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(ANIMATABLE_PROPERTIES_NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 3: 
        localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 2: 
        localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        localAnimatableColorValue1 = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
        break;
      case 0: 
        localAnimatableColorValue2 = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
      }
    }
    paramJsonReader.endObject();
    return new AnimatableTextProperties(localAnimatableColorValue2, localAnimatableColorValue1, localAnimatableFloatValue2, localAnimatableFloatValue1);
  }
}
