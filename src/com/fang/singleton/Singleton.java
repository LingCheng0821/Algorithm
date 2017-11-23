package com.fang.singleton;

public class Singleton {
  
  private Singleton(){};
  
 
  /**
   *  1、饿汉模式 
   */ 
 /* 
    private static final Singleton instance = new Singleton();
    public static Singleton getInstance(){
      return instance;
    }
  */
  
  /**
   * 2、不安全的懒汉模式
   */
  /*
     private static Singleton instance;
     public static Singleton getInstance(){
       if(instance == null)
         instance = new Singleton();
       return instance;
     }
   */
  
  /**
   * 3、不安全的双重检查锁定
   */
  
   /*
       private static Singleton instance;
       public static Singleton getInstance(){
         if(instance == null){
           synchronized (Singleton.class) {
             if(instance == null)
               instance = new Singleton();
          }
         }
         return instance;
       }
     */
   
  /**
   * 4、安全的双重检查锁定
   */
 /* 
    private volatile static Singleton instance;
    public static Singleton getInstance(){
      if(instance == null){
        synchronized (Singleton.class) {
          if(instance == null)
            instance = new Singleton();
        }      
      }
      return instance;
    }
  */
  
  /**
   * 5、类初始化的解决方案
   */ 
   /*
      private static class InstanceHolder{
        public static Singleton instance = new Singleton();
      }
      
      public static Singleton getInstance(){
        return InstanceHolder.instance;
      }
    */
  
//  public enum Singleton{
//    INSTANCE;
//  }
  
 
    
    private static enum Singleton1{
        INSTANCE;
        
        public static Singleton1 getInst(){
          return INSTANCE;
        }
    }

}
