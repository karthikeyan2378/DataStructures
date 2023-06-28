package DesignPatterns;

interface ShapeAbstract{
    void draw();
}

class RoundedRectangle implements ShapeAbstract {
    @Override
    public void draw()
    {
        System.out.println("RoundedRectangle = " + true);
    }
}

class RectangleAbs implements ShapeAbstract {
    @Override
    public void draw()
    {
        System.out.println("Rectangle = " + true);
    }
}

class RoundedSquare implements ShapeAbstract {
    @Override
    public void draw()
    {
        System.out.println("RoundedSquare = " + true);
    }
}

class SquareAbs implements ShapeAbstract {
    @Override
    public void draw()
    {
        System.out.println("Square = " + true);
    }
}

abstract class AbstractFactoryFact {
    abstract ShapeAbstract getShape(String shapeType) ;
}

class ShapeFactoryAbs extends AbstractFactoryFact {
    @Override
    public ShapeAbstract getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RectangleAbs();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new SquareAbs();
        }
        return null;
    }
}

class RoundedShapeFactory extends AbstractFactoryFact {
    @Override
    public ShapeAbstract getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactoryFact getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        }else{
            return new ShapeFactoryAbs();
        }
    }
}


public class AbstractFactory {
    public static void main(String[] args) {
        AbstractFactoryFact shapeFactory = FactoryProducer.getFactory(false);
        ShapeAbstract shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();
        ShapeAbstract shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        AbstractFactoryFact shapeFactory1 = FactoryProducer.getFactory(true);
        ShapeAbstract shape3 = shapeFactory1.getShape("RECTANGLE");
        shape3.draw();
        ShapeAbstract shape4 = shapeFactory1.getShape("SQUARE");
        shape4.draw();

    }
}
