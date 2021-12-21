package com.facebook.react.module.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ReactModule
{
  boolean canOverrideExistingModule();
  
  boolean hasConstants();
  
  boolean isCxxModule();
  
  String name();
  
  boolean needsEagerInit();
}
