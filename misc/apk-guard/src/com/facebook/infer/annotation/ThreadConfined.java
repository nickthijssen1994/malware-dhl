package com.facebook.infer.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
public @interface ThreadConfined
{
  public static final String SQL_UPDATE_6_4 = "ANY";
  public static final String TAG = "UI";
  
  String value();
}
