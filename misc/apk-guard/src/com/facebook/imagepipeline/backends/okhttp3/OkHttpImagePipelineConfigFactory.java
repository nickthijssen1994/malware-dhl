package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import okhttp3.OkHttpClient;

public class OkHttpImagePipelineConfigFactory
{
  public OkHttpImagePipelineConfigFactory() {}
  
  public static ImagePipelineConfig.Builder newBuilder(Context paramContext, OkHttpClient paramOkHttpClient)
  {
    return ImagePipelineConfig.newBuilder(paramContext).setNetworkFetcher(new OkHttpNetworkFetcher(paramOkHttpClient));
  }
}
