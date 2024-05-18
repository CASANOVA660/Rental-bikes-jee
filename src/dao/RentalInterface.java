package dao;

import Beans.Rental;
import java.util.List;

public interface RentalInterface {
    void getRentalById(int id);
    List<Rental> getAllRentals();
    void addRental(Rental rental);
    void updateRental(Rental rental);
    void deleteRental(int id);
}
