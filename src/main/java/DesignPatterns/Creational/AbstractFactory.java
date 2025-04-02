package DesignPatterns.Creational;

interface ShapeAbstract{
    void draw();
    default void drawing()
    {
        System.out.println("DRAW Anything");
    }
    
    static int squareRoot(int number)
    {
        return number*number;
    }
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

class RoundedHexagon implements ShapeAbstract {
    @Override
    public void draw()
    {
        System.out.println("RoundedHexagon = " + true);
    }
}

class HexagonAbs implements ShapeAbstract {
    @Override
    public void draw()
    {
        System.out.println("Hexagon = " + true);
    }
}


abstract class AbstractFactoryFact {
    abstract ShapeAbstract getShape(String shapeType) ;

    abstract void shape(String shapeType);

    static void staticCalled(){
        System.out.println(" ABSTRACT CLASS CALLED");
    }


    final void finalCalled()
    {
        System.out.println(" FINAL ABSTRACT CLASS CALLED");

    }
}

class ShapeFactoryAbs extends AbstractFactoryFact {
    @Override
    public ShapeAbstract getShape(String shapeType){
        shape(shapeType);
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RectangleAbs();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new SquareAbs();
        }
        else if(shapeType.equalsIgnoreCase("HEXAGON"))
        {
            return new HexagonAbs();
        }
            return null;
    }

    @Override
    void shape(String shapeType) {
        System.out.println("NORMAL" + shapeType);
    }


}

class RoundedShapeFactory extends AbstractFactoryFact {
    @Override
    public ShapeAbstract getShape(String shapeType){
        shape(shapeType);
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        else if(shapeType.equalsIgnoreCase("HEXAGON"))
        {
            return new RoundedHexagon();
        }

        return null;
    }

    @Override
    void shape(String shapeType) {
        System.out.println("ROUNDED" +shapeType);
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
        shape1.drawing();
        int squareRoot = ShapeAbstract.squareRoot(6);
        System.out.println("squareRoot = " + squareRoot);
        ShapeAbstract shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        ShapeAbstract shape5 = shapeFactory.getShape("HEXAGON");
        shape5.draw();
        AbstractFactoryFact shapeFactory1 = FactoryProducer.getFactory(true);
        shapeFactory1.finalCalled();
        AbstractFactoryFact.staticCalled();
        ShapeAbstract shape3 = shapeFactory1.getShape("RECTANGLE");
        shape3.draw();
        ShapeAbstract shape4 = shapeFactory1.getShape("SQUARE");
        shape4.draw();
        ShapeAbstract shape6 = shapeFactory1.getShape("HEXAGON");
        shape6.draw();

    }
}
