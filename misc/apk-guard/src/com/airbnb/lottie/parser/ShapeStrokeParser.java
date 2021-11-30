package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ShapeStrokeParser
{
  private static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.init(new String[] { "n", "v" });
  private static JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d" });
  
  private ShapeStrokeParser() {}
  
  static ShapeStroke parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Object localObject1 = null;
    AnimatableColorValue localAnimatableColorValue = null;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    AnimatableFloatValue localAnimatableFloatValue = null;
    ShapeStroke.LineCapType localLineCapType = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    float f = 0.0F;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 8: 
        paramJsonReader.beginArray();
        Object localObject2 = localObject1;
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginObject();
          String str2 = null;
          localObject1 = null;
          while (paramJsonReader.hasNext()) {
            switch (paramJsonReader.selectName(DASH_PATTERN_NAMES))
            {
            default: 
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
              break;
            case 1: 
              localObject1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
              break;
            case 0: 
              str2 = paramJsonReader.nextString();
            }
          }
          paramJsonReader.endObject();
          int i = str2.hashCode();
          if (i != 100)
          {
            if (i != 103)
            {
              if ((i == 111) && (str2.equals("o")))
              {
                i = 0;
                break label319;
              }
            }
            else if (str2.equals("g"))
            {
              i = 2;
              break label319;
            }
          }
          else if (str2.equals("d"))
          {
            i = 1;
            break label319;
          }
          i = -1;
          switch (i)
          {
          default: 
            break;
          case 1: 
          case 2: 
            paramLottieComposition.setHasDashPattern(true);
            localArrayList.add(localObject1);
            break;
          case 0: 
            localObject2 = localObject1;
          }
        }
        paramJsonReader.endArray();
        if (localArrayList.size() == 1)
        {
          localArrayList.add(localArrayList.get(0));
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
        }
        break;
      case 7: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 6: 
        f = (float)paramJsonReader.nextDouble();
        break;
      case 5: 
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJsonReader.nextInt() - 1)];
        break;
      case 4: 
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJsonReader.nextInt() - 1)];
        break;
      case 3: 
        localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        break;
      case 2: 
        localAnimatableFloatValue = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        localAnimatableColorValue = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
        break;
      case 0: 
        label319:
        str1 = paramJsonReader.nextString();
      }
    }
    return new ShapeStroke(str1, (AnimatableFloatValue)localObject1, localArrayList, localAnimatableColorValue, localAnimatableIntegerValue, localAnimatableFloatValue, localLineCapType, localLineJoinType, f, bool);
  }
}
