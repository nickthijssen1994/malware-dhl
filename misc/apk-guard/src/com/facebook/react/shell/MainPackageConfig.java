package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MainPackageConfig
{
  private ImagePipelineConfig mFrescoConfig;
  
  private MainPackageConfig(Builder paramBuilder)
  {
    mFrescoConfig = mFrescoConfig;
  }
  
  public ImagePipelineConfig getFrescoConfig()
  {
    return mFrescoConfig;
  }
  
  public static class Builder
  {
    private ImagePipelineConfig mFrescoConfig;
    
    public Builder() {}
    
    public MainPackageConfig build()
    {
      return new MainPackageConfig(this, null);
    }
    
    public Builder setFrescoConfig(ImagePipelineConfig paramImagePipelineConfig)
    {
      mFrescoConfig = paramImagePipelineConfig;
      return this;
    }
  }
}
