package com.airbnb.lottie.animation.content;

import android.graphics.Path;

abstract interface PathContent
  extends Content
{
  public abstract Path getPath();
}
