package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class DraweeConfig
{
  @Nullable
  private final ImmutableList<DrawableFactory> mCustomDrawableFactories;
  private final Supplier<Boolean> mDebugOverlayEnabledSupplier;
  @Nullable
  private final ImagePerfDataListener mImagePerfDataListener;
  @Nullable
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;
  
  private DraweeConfig(Builder paramBuilder)
  {
    Object localObject;
    if (mCustomDrawableFactories != null) {
      localObject = ImmutableList.copyOf(mCustomDrawableFactories);
    } else {
      localObject = null;
    }
    mCustomDrawableFactories = ((ImmutableList)localObject);
    if (mDebugOverlayEnabledSupplier != null) {
      localObject = mDebugOverlayEnabledSupplier;
    } else {
      localObject = Suppliers.cache(Boolean.valueOf(false));
    }
    mDebugOverlayEnabledSupplier = ((Supplier)localObject);
    mPipelineDraweeControllerFactory = mPipelineDraweeControllerFactory;
    mImagePerfDataListener = mImagePerfDataListener;
  }
  
  public static Builder newBuilder()
  {
    return new Builder();
  }
  
  public ImmutableList getCustomDrawableFactories()
  {
    return mCustomDrawableFactories;
  }
  
  public Supplier getDebugOverlayEnabledSupplier()
  {
    return mDebugOverlayEnabledSupplier;
  }
  
  public ImagePerfDataListener getImagePerfDataListener()
  {
    return mImagePerfDataListener;
  }
  
  public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory()
  {
    return mPipelineDraweeControllerFactory;
  }
  
  public static class Builder
  {
    private List<DrawableFactory> mCustomDrawableFactories;
    private Supplier<Boolean> mDebugOverlayEnabledSupplier;
    @Nullable
    private ImagePerfDataListener mImagePerfDataListener;
    private PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;
    
    public Builder() {}
    
    public Builder addCustomDrawableFactory(DrawableFactory paramDrawableFactory)
    {
      if (mCustomDrawableFactories == null) {
        mCustomDrawableFactories = new ArrayList();
      }
      mCustomDrawableFactories.add(paramDrawableFactory);
      return this;
    }
    
    public DraweeConfig build()
    {
      return new DraweeConfig(this, null);
    }
    
    public Builder setDebugOverlayEnabledSupplier(Supplier paramSupplier)
    {
      Preconditions.checkNotNull(paramSupplier);
      mDebugOverlayEnabledSupplier = paramSupplier;
      return this;
    }
    
    public Builder setDrawDebugOverlay(boolean paramBoolean)
    {
      return setDebugOverlayEnabledSupplier(Suppliers.cache(Boolean.valueOf(paramBoolean)));
    }
    
    public Builder setImagePerfDataListener(ImagePerfDataListener paramImagePerfDataListener)
    {
      mImagePerfDataListener = paramImagePerfDataListener;
      return this;
    }
    
    public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory paramPipelineDraweeControllerFactory)
    {
      mPipelineDraweeControllerFactory = paramPipelineDraweeControllerFactory;
      return this;
    }
  }
}
