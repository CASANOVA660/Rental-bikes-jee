package dao;

import Beans.Bike;
import java.util.List;

public interface BikeInterface {
    void getBikeById(int id);
    List<Bike> getAllBikes();
    void addBike(Bike bike);
    void updateBike(Bike bike);
    void deleteBike(int id);
}
