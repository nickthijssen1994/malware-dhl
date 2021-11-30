package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;

public class ReactNetworkImageRequest
  extends ImageRequest
{
  private final ReadableMap mHeaders;
  
  protected ReactNetworkImageRequest(ImageRequestBuilder paramImageRequestBuilder, ReadableMap paramReadableMap)
  {
    super(paramImageRequestBuilder);
    mHeaders = paramReadableMap;
  }
  
  public static ReactNetworkImageRequest fromBuilderWithHeaders(ImageRequestBuilder paramImageRequestBuilder, ReadableMap paramReadableMap)
  {
    return new ReactNetworkImageRequest(paramImageRequestBuilder, paramReadableMap);
  }
  
  public ReadableMap getHeaders()
  {
    return mHeaders;
  }
}
