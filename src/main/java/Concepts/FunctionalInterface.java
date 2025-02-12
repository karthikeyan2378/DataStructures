package Concepts;

@FunctionalInterface
interface ShapeCalculator {
    double calculateArea();
}

interface Displayable {
    default void displayArea(ShapeCalculator shape) {
        System.out.println("Default Display: " + shape.calculateArea());
    }
}

class Circle implements ShapeCalculator {
    private double radius;

    // Constructor for Circle class
    Circle(double radius) {
        this.radius = radius;
    }

    // Override the calculateArea() method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements ShapeCalculator {
    private double length;
    private double width;

    // Constructor for Rectangle class
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Override the calculateArea() method
    @Override
    public double calculateArea() {
        return length * width;
    }
}

abstract class Square implements ShapeCalculator {
    private double side;

    // Constructor for Square class
    public Square(double side) {
        this.side = side;
    }
}

 class ShapeDemo implements Displayable {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Square square = new Square(4.0) {
            @Override
            public double calculateArea() {
                return 0;
            }
        };

        // Calculate and display areas using the functional interface
        new ShapeDemo().displayArea(circle);
        new ShapeDemo().displayArea(rectangle);
        new ShapeDemo().displayArea(square);
    }
}
