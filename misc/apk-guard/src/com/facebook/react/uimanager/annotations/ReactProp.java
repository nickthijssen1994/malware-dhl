package com.facebook.react.uimanager.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface ReactProp
{
  public static final String USE_DEFAULT_TYPE = "__default_type__";
  
  String customType();
  
  boolean defaultBoolean();
  
  double defaultDouble();
  
  float defaultFloat();
  
  int defaultInt();
  
  String name();
}
