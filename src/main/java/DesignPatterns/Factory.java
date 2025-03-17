package DesignPatterns;

interface Shape{
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw()
    {
        System.out.println("rectangle = " + true);
    }
}

class Circle implements Shape {
    @Override
    public void draw()
    {
        System.out.println("Circle = " + true);
    }
}

class Square implements Shape {
    @Override
    public void draw()
    {
        System.out.println("Square = " + true);
    }
}

class Hexagon implements Shape {
    @Override
    public void draw() {
        System.out.println("Hexagon = " + true);
    }
}
class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        else if(shapeType.equalsIgnoreCase("HEXAGON"))
        {
            return new Hexagon();
        }
        return null;
    }
}

public class Factory {
    public static void main(String[] args) {
        ShapeFactory s = new ShapeFactory();
        Shape s1 = s.getShape("circle");
        s1.draw();
        Shape s2 = s.getShape("rectangle");
        s2.draw();
        Shape s3 = s.getShape("square");
        s3.draw();
        Shape s4 = s.getShape("hexagon");
        s4.draw();

    }
}
