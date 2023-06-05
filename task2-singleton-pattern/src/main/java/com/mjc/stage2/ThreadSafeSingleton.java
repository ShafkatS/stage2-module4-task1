package com.mjc.stage2;

public class ThreadSafeSingleton {
  private static ThreadSafeSingleton threadSafeSingleton = new ThreadSafeSingleton();
   
    
    
  private ThreadSafeSingleton() {    }

  public static ThreadSafeSingleton getInstance() {
        return threadSafeSingleton;
    }
}
