package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

abstract interface ValueParser<V>
{
  public abstract Object parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException;
}
