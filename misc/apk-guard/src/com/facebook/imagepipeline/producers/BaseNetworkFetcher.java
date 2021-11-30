package com.facebook.imagepipeline.producers;

import java.util.Map;

public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState>
  implements NetworkFetcher<FETCH_STATE>
{
  public BaseNetworkFetcher() {}
  
  public Map getExtraMap(FetchState paramFetchState, int paramInt)
  {
    return null;
  }
  
  public void onFetchCompletion(FetchState paramFetchState, int paramInt) {}
  
  public boolean shouldPropagate(FetchState paramFetchState)
  {
    return true;
  }
}
