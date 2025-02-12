package Concepts;

public class AbstractClass {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println("c = " + c);
        System.out.println(c.calculateArea());
         
    }
}

abstract class Shape {
    abstract double calculateArea();
}

