package DesignPatterns.Creational;

// Step 1: Define the Builder Interface
interface CarBuilder {
    CarBuilder setSunroof(boolean sunroof);
    CarBuilder setColor(String color);
    CarBuilder setGearType(String type);
    Car build();
}

 enum type {
    AUTOMATIC,
    MANUAL
}
// Step 2: Implement the Builder Class
class Car {
    private final String engine;
    private final int wheels;
    private final boolean sunroof;
    private final String color;
    private final String type;

    private Car(ConcreteCarBuilder builder, String type) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
        this.color = builder.color;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                ", sunroof=" + sunroof +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    // Concrete Builder implementing the CarBuilder interface
    static class ConcreteCarBuilder implements CarBuilder {
        private final String engine;
        private final int wheels;
        private boolean sunroof;
        private String color;
        private String type;

        public ConcreteCarBuilder(String engine, int wheels) { // Required parameters
            this.engine = engine;
            this.wheels = wheels;
        }

        @Override
        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        @Override
        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        @Override
        public CarBuilder setGearType(String type) {
            this.type = type;
            return this;
        }


        @Override
        public Car build() {
            return new Car(this, type);
        }
    }

}

class Main {
    public static void main(String[] args) {
        CarBuilder builder = new Car.ConcreteCarBuilder("V8", 4);
        Car car = builder
                .setSunroof(true)
                .setColor("Blue").setGearType(String.valueOf(type.MANUAL))
                .build();

        System.out.println(car);
        
        //Enum methods
        
        for(type type :type.values())
            System.out.println("type = " + type);

        type type = DesignPatterns.Creational.type.valueOf("MANUAL");
        System.out.println("type = " + type);
    }
}
