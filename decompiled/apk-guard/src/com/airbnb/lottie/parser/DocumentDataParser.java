package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.DocumentData.Justification;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

public class DocumentDataParser
  implements ValueParser<DocumentData>
{
  public static final DocumentDataParser INSTANCE = new DocumentDataParser();
  private static final JsonReader.Options NAMES = JsonReader.Options.init(new String[] { "t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of" });
  
  private DocumentDataParser() {}
  
  public DocumentData parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    DocumentData.Justification localJustification = DocumentData.Justification.CENTER;
    paramJsonReader.beginObject();
    String str2 = null;
    String str1 = null;
    paramFloat = 0.0F;
    int k = 0;
    float f3 = 0.0F;
    float f2 = 0.0F;
    int j = 0;
    int i = 0;
    float f1 = 0.0F;
    boolean bool = true;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 10: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 9: 
        f1 = (float)paramJsonReader.nextDouble();
        break;
      case 8: 
        i = JsonUtils.jsonToColor(paramJsonReader);
        break;
      case 7: 
        j = JsonUtils.jsonToColor(paramJsonReader);
        break;
      case 6: 
        f2 = (float)paramJsonReader.nextDouble();
        break;
      case 5: 
        f3 = (float)paramJsonReader.nextDouble();
        break;
      case 4: 
        k = paramJsonReader.nextInt();
        break;
      case 3: 
        int m = paramJsonReader.nextInt();
        if ((m <= DocumentData.Justification.CENTER.ordinal()) && (m >= 0)) {
          localJustification = DocumentData.Justification.values()[m];
        } else {
          localJustification = DocumentData.Justification.CENTER;
        }
        break;
      case 2: 
        paramFloat = (float)paramJsonReader.nextDouble();
        break;
      case 1: 
        str1 = paramJsonReader.nextString();
        break;
      case 0: 
        str2 = paramJsonReader.nextString();
      }
    }
    paramJsonReader.endObject();
    return new DocumentData(str2, str1, paramFloat, localJustification, k, f3, f2, j, i, f1, bool);
  }
}
