package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.MergePaths.MergePathsMode;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

class MergePathsParser
{
  private static final JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "nm", "mm", "hd" });
  
  private MergePathsParser() {}
  
  static MergePaths parse(JsonReader paramJsonReader)
    throws IOException
  {
    String str = null;
    MergePaths.MergePathsMode localMergePathsMode = null;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 2: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 1: 
        localMergePathsMode = MergePaths.MergePathsMode.forId(paramJsonReader.nextInt());
        break;
      case 0: 
        str = paramJsonReader.nextString();
      }
    }
    return new MergePaths(str, localMergePathsMode, bool);
  }
}
