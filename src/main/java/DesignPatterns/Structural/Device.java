package DesignPatterns.Structural;

import java.util.*;
import java.util.stream.Collectors;

public interface Device {
    void onDevice();
    void offDevice();
}

class Tv implements Device {

    @Override
    public void onDevice() {
        System.out.println("TV is ON");
    }

    @Override
    public void offDevice() {
        System.out.println("TV is OFF");

    }
}

class Radio implements Device {

    @Override
    public void onDevice() {
        System.out.println("Radio is ON");
    }

    @Override
    public void offDevice() {
        System.out.println("Radio is OFF");

    }
}

abstract class RemoteControl{
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    abstract void pressOnButton();
    abstract void pressOffButton();
}

class BasicRemoteControl extends RemoteControl {

    public BasicRemoteControl(Device device)
    {
        super(device);
    }

    @Override
    void pressOnButton() {
        device.onDevice();
    }

    @Override
    void pressOffButton() {
        device.offDevice();
    }
}

class BridgePatternDemo{
    public static void main(String[] args) {
        Device tv = new Tv();
        RemoteControl remoteControl = new BasicRemoteControl(tv);
        remoteControl.pressOnButton();;
        remoteControl.pressOffButton();

        Device Radio = new Radio();
        RemoteControl remoteControl1 = new BasicRemoteControl(Radio);
        remoteControl1.pressOnButton();
        remoteControl1.pressOffButton();
        String stringBuilder = new StringBuilder("JAVA").reverse().toString();
        System.out.println("stringBuilder = " + stringBuilder);
    }
}

class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =1;i<=n;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(i, 1+map.get(i));
            }
            else
            {
                map.put(i, 1);
            }

        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i<=n;i++)
        {
            if(map.get(i)!=null)
                res.add(i);
            else
                res.add(map.get(i));
        }
        return res;
    }
}
