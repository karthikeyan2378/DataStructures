package DesignPatterns.Structural;

import java.util.ArrayList;
import java.util.List;

public interface Voltage5v {
    int getVoltage5V();
}

class Voltage220V{
    int getVoltage220V() {
        return 220;
    }
}

//object adapter uses composition
class voltageAdaptor implements Voltage5v {
    private Voltage220V voltage220V;

    public voltageAdaptor(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;

    }

    @Override
    public int getVoltage5V() {
        int volts = voltage220V.getVoltage220V();
        //converts from 220v to 5v
        return volts/44;
    }

    public static void main(String[] args) {
        Voltage220V voltage220V = new Voltage220V();
        Voltage5v voltage5v = new voltageAdaptor(voltage220V);

        System.out.println("voltage5v.getVoltage5V() = " + voltage5v.getVoltage5V());
    }
}

//class adapter uses extends and implements interface

class voltageClassAdaptor extends Voltage220V implements Voltage5v {

    @Override
    public int getVoltage5V() {
        int volts = getVoltage220V();
        //converts from 220v to 5v
        return volts/44;
    }

    public static void main(String[] args) {
        Voltage5v voltage5v = new voltageClassAdaptor();

        System.out.println("class adapter voltage5v.getVoltage5V() = " + voltage5v.getVoltage5V());
    }
}
