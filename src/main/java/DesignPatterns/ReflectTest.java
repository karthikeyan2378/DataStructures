package DesignPatterns;

import java.lang.reflect.Constructor;

class ReflectTest {
    

    public ReflectTest() throws ClassNotFoundException {
        
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("DesignPatterns.EagerSingleton");
        System.out.println("c = " + c);
        Constructor[] ad = c.getDeclaredConstructors();
        for (Constructor as:ad) {
            System.out.println("as = " + as);
        }

        System.out.println("ad = " + ad.toString());
    }
}
