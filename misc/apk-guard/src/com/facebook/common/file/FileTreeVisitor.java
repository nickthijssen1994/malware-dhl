package com.facebook.common.file;

import java.io.File;

public abstract interface FileTreeVisitor
{
  public abstract void postVisitDirectory(File paramFile);
  
  public abstract void preVisitDirectory(File paramFile);
  
  public abstract void visitFile(File paramFile);
}
