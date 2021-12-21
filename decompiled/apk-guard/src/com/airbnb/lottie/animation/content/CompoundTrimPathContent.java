package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent
{
  private List<TrimPathContent> contents = new ArrayList();
  
  public CompoundTrimPathContent() {}
  
  void addTrimPath(TrimPathContent paramTrimPathContent)
  {
    contents.add(paramTrimPathContent);
  }
  
  public void apply(Path paramPath)
  {
    int i = contents.size() - 1;
    while (i >= 0)
    {
      Utils.applyTrimPathIfNeeded(paramPath, (TrimPathContent)contents.get(i));
      i -= 1;
    }
  }
}
