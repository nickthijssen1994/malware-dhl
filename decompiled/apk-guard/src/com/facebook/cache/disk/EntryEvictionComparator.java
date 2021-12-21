package com.facebook.cache.disk;

import java.util.Comparator;

public abstract interface EntryEvictionComparator
  extends Comparator<DiskStorage.Entry>
{}
