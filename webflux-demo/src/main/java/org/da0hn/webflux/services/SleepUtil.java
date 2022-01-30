package org.da0hn.webflux.services;

import java.util.concurrent.TimeUnit;

public class SleepUtil {


  public static void sleep(final int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    }
    catch(final InterruptedException e) {
      e.printStackTrace();
    }
  }


}
