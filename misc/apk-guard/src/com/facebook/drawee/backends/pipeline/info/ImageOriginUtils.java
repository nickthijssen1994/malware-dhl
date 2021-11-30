package com.facebook.drawee.backends.pipeline.info;

public class ImageOriginUtils
{
  private ImageOriginUtils() {}
  
  public static int mapProducerNameToImageOrigin(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2113652014: 
      if (paramString.equals("LocalContentUriFetchProducer")) {
        i = 9;
      }
      break;
    case 2109593398: 
      if (paramString.equals("PartialDiskCacheProducer")) {
        i = 5;
      }
      break;
    case 1793127518: 
      if (paramString.equals("LocalContentUriThumbnailFetchProducer")) {
        i = 10;
      }
      break;
    case 1721672898: 
      if (paramString.equals("DataFetchProducer")) {
        i = 7;
      }
      break;
    case 1023071510: 
      if (paramString.equals("PostprocessedBitmapMemoryCacheProducer")) {
        i = 2;
      }
      break;
    case 1019542023: 
      if (paramString.equals("LocalAssetFetchProducer")) {
        i = 8;
      }
      break;
    case 957714404: 
      if (paramString.equals("BitmapMemoryCacheProducer")) {
        i = 1;
      }
      break;
    case 656304759: 
      if (paramString.equals("DiskCacheProducer")) {
        i = 4;
      }
      break;
    case 473552259: 
      if (paramString.equals("VideoThumbnailProducer")) {
        i = 13;
      }
      break;
    case -1224383234: 
      if (paramString.equals("NetworkFetchProducer")) {
        i = 6;
      }
      break;
    case -1307634203: 
      if (paramString.equals("EncodedMemoryCacheProducer")) {
        i = 3;
      }
      break;
    case -1579985851: 
      if (paramString.equals("LocalFileFetchProducer")) {
        i = 11;
      }
      break;
    case -1683996557: 
      if (paramString.equals("LocalResourceFetchProducer")) {
        i = 12;
      }
      break;
    case -1914072202: 
      if (paramString.equals("BitmapMemoryCacheGetProducer")) {
        i = 0;
      }
      break;
    case -1917159454: 
      if (paramString.equals("QualifiedResourceFetchProducer")) {
        i = 14;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return 1;
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
      return 6;
    case 6: 
      return 2;
    case 4: 
    case 5: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  public static String toString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 6: 
      return "local";
    case 5: 
      return "memory_bitmap";
    case 4: 
      return "memory_encoded";
    case 3: 
      return "disk";
    }
    return "network";
  }
}
