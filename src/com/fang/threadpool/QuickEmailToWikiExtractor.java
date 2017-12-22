package com.fang.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QuickEmailToWikiExtractor /*extends AbstractExtractor*/{
  private ThreadPoolExecutor executor;
  private BlockingQueue<String> emailQueue;

  public QuickEmailToWikiExtractor() {
    this.emailQueue = new LinkedBlockingQueue<String>();
    int coreSize = Runtime.getRuntime().availableProcessors()*2;
    this.executor = new ThreadPoolExecutor(coreSize, coreSize, 10L, TimeUnit.SECONDS, 
        new LinkedBlockingQueue<Runnable>(2000));
  }
  
  
  
}
