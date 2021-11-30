package com.facebook.debug.holder;

public class PrinterHolder
{
  private static Printer sPrinter = NoopPrinter.INSTANCE;
  
  public PrinterHolder() {}
  
  public static Printer getPrinter()
  {
    return sPrinter;
  }
  
  public static void setPrinter(Printer paramPrinter)
  {
    if (paramPrinter == null)
    {
      sPrinter = NoopPrinter.INSTANCE;
      return;
    }
    sPrinter = paramPrinter;
  }
}
