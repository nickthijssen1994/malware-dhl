package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.List;

public class AnimatableValueParser
{
  private AnimatableValueParser() {}
  
  private static List parse(JsonReader paramJsonReader, float paramFloat, LottieComposition paramLottieComposition, ValueParser paramValueParser)
    throws IOException
  {
    return KeyframesParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser);
  }
  
  private static List parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, ValueParser paramValueParser)
    throws IOException
  {
    return KeyframesParser.parse(paramJsonReader, paramLottieComposition, 1.0F, paramValueParser);
  }
  
  static AnimatableColorValue parseColor(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableColorValue(parse(paramJsonReader, paramLottieComposition, ColorParser.INSTANCE));
  }
  
  static AnimatableTextFrame parseDocumentData(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableTextFrame(parse(paramJsonReader, paramLottieComposition, DocumentDataParser.INSTANCE));
  }
  
  public static AnimatableFloatValue parseFloat(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return parseFloat(paramJsonReader, paramLottieComposition, true);
  }
  
  public static AnimatableFloatValue parseFloat(JsonReader paramJsonReader, LottieComposition paramLottieComposition, boolean paramBoolean)
    throws IOException
  {
    float f;
    if (paramBoolean) {
      f = Utils.dpScale();
    } else {
      f = 1.0F;
    }
    return new AnimatableFloatValue(parse(paramJsonReader, f, paramLottieComposition, FloatParser.INSTANCE));
  }
  
  static AnimatableGradientColorValue parseGradientColor(JsonReader paramJsonReader, LottieComposition paramLottieComposition, int paramInt)
    throws IOException
  {
    return new AnimatableGradientColorValue(parse(paramJsonReader, paramLottieComposition, new GradientColorParser(paramInt)));
  }
  
  static AnimatableIntegerValue parseInteger(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableIntegerValue(parse(paramJsonReader, paramLottieComposition, IntegerParser.INSTANCE));
  }
  
  static AnimatablePointValue parsePoint(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatablePointValue(parse(paramJsonReader, Utils.dpScale(), paramLottieComposition, PointFParser.INSTANCE));
  }
  
  static AnimatableScaleValue parseScale(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableScaleValue(parse(paramJsonReader, paramLottieComposition, ScaleXYParser.INSTANCE));
  }
  
  static AnimatableShapeValue parseShapeData(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableShapeValue(parse(paramJsonReader, Utils.dpScale(), paramLottieComposition, ShapeDataParser.INSTANCE));
  }
}
