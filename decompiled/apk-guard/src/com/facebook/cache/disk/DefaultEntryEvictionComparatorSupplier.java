package com.facebook.cache.disk;

public class DefaultEntryEvictionComparatorSupplier
  implements EntryEvictionComparatorSupplier
{
  public DefaultEntryEvictionComparatorSupplier() {}
  
  public EntryEvictionComparator getLastSms()
  {
    new EntryEvictionComparator()
    {
      public int compare(DiskStorage.Entry paramAnonymousEntry1, DiskStorage.Entry paramAnonymousEntry2)
      {
        long l1 = paramAnonymousEntry1.getTimestamp();
        long l2 = paramAnonymousEntry2.getTimestamp();
        if (l1 < l2) {
          return -1;
        }
        if (l2 == l1) {
          return 0;
        }
        return 1;
      }
    };
  }
}
