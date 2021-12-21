package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class KeyframesParser
{
  static JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "k" });
  
  private KeyframesParser() {}
  
  static List parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, float paramFloat, ValueParser paramValueParser)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonReader.peek() == JsonReader.Token.STRING)
    {
      paramLottieComposition.addWarning("Lottie doesn't support expressions.");
      return localArrayList;
    }
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext()) {
      if (paramJsonReader.selectName(NAMES) != 0)
      {
        paramJsonReader.skipValue();
      }
      else if (paramJsonReader.peek() == JsonReader.Token.BEGIN_ARRAY)
      {
        paramJsonReader.beginArray();
        if (paramJsonReader.peek() == JsonReader.Token.NUMBER) {
          localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, false));
        } else {
          while (paramJsonReader.hasNext()) {
            localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, true));
          }
        }
        paramJsonReader.endArray();
      }
      else
      {
        localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, false));
      }
    }
    paramJsonReader.endObject();
    setEndFrames(localArrayList);
    return localArrayList;
  }
  
  public static void setEndFrames(List paramList)
  {
    int k = paramList.size();
    int i = 0;
    int j;
    for (;;)
    {
      j = k - 1;
      if (i >= j) {
        break;
      }
      localKeyframe1 = (Keyframe)paramList.get(i);
      j = i + 1;
      Keyframe localKeyframe2 = (Keyframe)paramList.get(j);
      endFrame = Float.valueOf(startFrame);
      i = j;
      if (endValue == null)
      {
        i = j;
        if (startValue != null)
        {
          endValue = startValue;
          i = j;
          if ((localKeyframe1 instanceof PathKeyframe))
          {
            ((PathKeyframe)localKeyframe1).createPath();
            i = j;
          }
        }
      }
    }
    Keyframe localKeyframe1 = (Keyframe)paramList.get(j);
    if (((startValue == null) || (endValue == null)) && (paramList.size() > 1)) {
      paramList.remove(localKeyframe1);
    }
  }
}
