package DesignPatterns;

import java.lang.reflect.Constructor;

class EagerSingleton{

    private EagerSingleton(){};

    private static final EagerSingleton ins = new EagerSingleton();
    public static EagerSingleton getInstance(){
        return ins;
    }

    public static void main(String[] args) {
        EagerSingleton instance = EagerSingleton.getInstance();
        System.out.println("instance = " + instance);
        EagerSingleton instance1 = EagerSingleton.getInstance();
        System.out.println("instance1 = " + instance1);
    }
}

class EagerStaticBlockSingleton {
    private static final EagerStaticBlockSingleton ins1;

    public EagerStaticBlockSingleton(){}
    static {
        try{
            ins1 = new EagerStaticBlockSingleton();
        }
        catch (Exception e)
        {
            throw e;
        }
        System.out.println("ins2 = " + ins1);
    }
    {
        System.out.println("ins3 = " + ins1);
    }
    public static EagerStaticBlockSingleton getInstance() {
        System.out.println("ins1 = " + ins1);
        return ins1;
    }


    public static void main(String[] args) {
        EagerStaticBlockSingleton e1 = EagerStaticBlockSingleton.getInstance();
        EagerStaticBlockSingleton e3 = new EagerStaticBlockSingleton();
        System.out.println("e3 = " + e3);
        System.out.println("e1 = " + e1);
        EagerStaticBlockSingleton e2 = EagerStaticBlockSingleton.getInstance();
        System.out.println("e2 = " + e2);
    }
}

class LazySingleton {
   private static LazySingleton s;
   private LazySingleton(){}
   private static synchronized LazySingleton getInstance(){
       if(s == null){
           s = new LazySingleton();
       }
       return s;
   }

    public static void main(String[] args) {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println("instance = " + instance);
        LazySingleton ss = LazySingleton.getInstance();
        System.out.println("ss = " + ss);
    }

}

class LazyDoubleCheckedLockingSingleton {
public static volatile LazyDoubleCheckedLockingSingleton ip;

private LazyDoubleCheckedLockingSingleton(){}

public static LazyDoubleCheckedLockingSingleton getInstance(){
    if(ip == null){
        synchronized (LazyDoubleCheckedLockingSingleton.class){
            if(ip == null)
            {
                ip = new LazyDoubleCheckedLockingSingleton();
            }
        }
    }
    return ip;
}

    public static void main(String[] args) {
        LazyDoubleCheckedLockingSingleton instance = LazyDoubleCheckedLockingSingleton.getInstance();
        System.out.println("instance = " + instance);
    }
}

class LazyInnerClassSingleton {

   private LazyInnerClassSingleton() {}

   private static class SingletonHelper {
       private static final LazyInnerClassSingleton INSTANCE = new LazyInnerClassSingleton();
   }

   public static LazyInnerClassSingleton getInstance() {
       return SingletonHelper.INSTANCE;
   }

    public static void main(String[] args) {
        LazyInnerClassSingleton instance = LazyInnerClassSingleton.getInstance();
        System.out.println("instance = " + instance);
        LazyInnerClassSingleton lazyInnerClassSingleton = new LazyInnerClassSingleton();
        System.out.println("lazyInnerClassSingleton = " + lazyInnerClassSingleton);
        LazyInnerClassSingleton lazyInnerClassSingleton1 = new LazyInnerClassSingleton();
        System.out.println("lazyInnerClassSingleton = " + lazyInnerClassSingleton1);
    }
}

class MySingleton {
    private static final MySingleton instance = new MySingleton();

    private MySingleton() {
        // protect against instantiation via reflection
        if(instance != null) {
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static MySingleton getInstance() {
        return instance;
    }
}


public class Singleton {
    public static void main(String[] args) {
        MySingleton singletonInstance = MySingleton.getInstance();
        MySingleton reflectionInstance = null;

        try {
            Constructor[] constructors = MySingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                reflectionInstance = (MySingleton) constructor.newInstance();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("singletonInstance hashCode: " + singletonInstance.hashCode());
        System.out.println("reflectionInstance hashCode: " + reflectionInstance.hashCode());
    }
}

