package com.facebook.imagepipeline.decoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormat.FormatChecker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageDecoderConfig
{
  private final Map<ImageFormat, ImageDecoder> mCustomImageDecoders;
  private final List<ImageFormat.FormatChecker> mCustomImageFormats;
  
  private ImageDecoderConfig(Builder paramBuilder)
  {
    mCustomImageDecoders = mCustomImageDecoders;
    mCustomImageFormats = mCustomImageFormats;
  }
  
  public static Builder newBuilder()
  {
    return new Builder();
  }
  
  public Map getCustomImageDecoders()
  {
    return mCustomImageDecoders;
  }
  
  public List getCustomImageFormats()
  {
    return mCustomImageFormats;
  }
  
  public static class Builder
  {
    private Map<ImageFormat, ImageDecoder> mCustomImageDecoders;
    private List<ImageFormat.FormatChecker> mCustomImageFormats;
    
    public Builder() {}
    
    public Builder addDecodingCapability(ImageFormat paramImageFormat, ImageFormat.FormatChecker paramFormatChecker, ImageDecoder paramImageDecoder)
    {
      if (mCustomImageFormats == null) {
        mCustomImageFormats = new ArrayList();
      }
      mCustomImageFormats.add(paramFormatChecker);
      overrideDecoder(paramImageFormat, paramImageDecoder);
      return this;
    }
    
    public ImageDecoderConfig build()
    {
      return new ImageDecoderConfig(this, null);
    }
    
    public Builder overrideDecoder(ImageFormat paramImageFormat, ImageDecoder paramImageDecoder)
    {
      if (mCustomImageDecoders == null) {
        mCustomImageDecoders = new HashMap();
      }
      mCustomImageDecoders.put(paramImageFormat, paramImageDecoder);
      return this;
    }
  }
}
