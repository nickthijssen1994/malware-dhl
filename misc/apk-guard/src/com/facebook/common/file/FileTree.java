package com.facebook.common.file;

import java.io.File;

public class FileTree
{
  public FileTree() {}
  
  public static boolean deleteContents(File paramFile)
  {
    paramFile = paramFile.listFiles();
    boolean bool = true;
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        bool &= deleteRecursively(paramFile[i]);
        i += 1;
      }
    }
    return true;
    return bool;
  }
  
  public static boolean deleteRecursively(File paramFile)
  {
    if (paramFile.isDirectory()) {
      deleteContents(paramFile);
    }
    return paramFile.delete();
  }
  
  public static void walkFileTree(File paramFile, FileTreeVisitor paramFileTreeVisitor)
  {
    paramFileTreeVisitor.preVisitDirectory(paramFile);
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          walkFileTree(localFile, paramFileTreeVisitor);
        } else {
          paramFileTreeVisitor.visitFile(localFile);
        }
        i += 1;
      }
    }
    paramFileTreeVisitor.postVisitDirectory(paramFile);
  }
}
