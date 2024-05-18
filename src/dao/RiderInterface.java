package dao;

import Beans.Rider;
import java.util.List;

public interface RiderInterface {
    void getRiderById(int id);
    List<Rider> getAllRiders();
    void addRider(Rider rider);
    void updateRider(Rider rider);
    void deleteRider(int id);
}
