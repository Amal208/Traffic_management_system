package ejb.impl;

import ejb.message.MessageReceiver;
import ejb.remote.TrafficRoot;
import jakarta.ejb.Singleton;

import java.util.List;

@Singleton
public class TrafficRootBean implements TrafficRoot {

    private boolean CLstatus = false;
    @Override
    public int vehicleCount(String vehicleCount) {


        /*String input = vehicleCount.split(",");
        int commaCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                commaCount++;
            }
        }*/
        System.out.println(vehicleCount.indexOf(1));
        int Count = 0;

        return Count;
    }

    @Override
    public int averageSpeed(int speed) {
        return speed;
    }

    @Override
    public boolean colorLightStatus(boolean status) {
        return false;
    }
}
