package DesignPatterns.Creational;

class EagerSingleton {


    // Eager Initialization (Simple, but creates instance even if not used)
    private static class Singleton {
        private static final Singleton instance = new Singleton();// Instance created at class loading

        private Singleton() { //privateContructor
        }

        public  static Singleton getInstance() {
            return instance;
        }
    }


}

class LazySingleton {

    // Lazy Initialization (Simple, doesnt creates instance  if not used)
    private static class Singleton {
        private static  Singleton instance;

        private Singleton() { //privateContructor
        }

        public  static Singleton getInstance() {
            if(instance == null) { // lazy loading only creates if required
                instance = new Singleton();
            }
            return instance;
        }
    }


}

class ThreadSafeSingleton {

    // Lazy Initialization (Simple, doesnt creates instance  if not used)
    private static class Singleton {
        private static  Singleton instance;

        private Singleton() { //privateContructor
        }

        public  static synchronized Singleton getInstance() { // use synchronized keyword for thread safe
            if(instance == null) { // lazy loading only creates if required
                instance = new Singleton();
            }
            return instance;
        }
    }
}

class DoubleCheckedLockingSingleton {
    // Lazy Initialization (Simple, doesnt creates instance  if not used)
    private static class Singleton {
        private static  Singleton instance;

        private Singleton() { //privateContructor
        }

        public  static Singleton getInstance() {
            if(instance == null) { // lazy loading only creates if required (not-locking)
                synchronized (Singleton.class) { // Locking for thread safety
                    if(instance == null) {
                        instance = new Singleton(); // Second check (inside synchronized block)
                    }
                }
            }
            return instance;
        }
    }
}

class BillPughSingleton {

    private static class Singleton {
        private Singleton() { //privateContructor
        }

        private static class SingleTonHelper{
            private static final Singleton instance = new Singleton(); // innerclass helps to create object
        }
        public static  Singleton getInstance() {
            return SingleTonHelper.instance;
        }
    }
}

enum Singleton {
    INSTANCE; // Enum instance

    public void showMessage() {
        System.out.println("Singleton using Enum!");
    }
}
