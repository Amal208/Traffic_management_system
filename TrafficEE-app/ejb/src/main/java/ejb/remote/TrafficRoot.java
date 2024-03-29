package ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface TrafficRoot {
    public int vehicleCount(String vehicleCount);
    public int averageSpeed(int speed);
    public boolean colorLightStatus(boolean status);

}
