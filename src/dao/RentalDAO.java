package dao;

import Beans.Rental;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO implements RentalInterface {

    private Connection connection;

    public RentalDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getRentalById(int id) {
        String query = "SELECT * FROM Rentals WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Rental rental = new Rental();
                rental.setId(rs.getInt("id"));
                rental.setUserId(rs.getInt("userId"));
                rental.setBikeId(rs.getInt("bikeId"));
                rental.setStartTime(rs.getTimestamp("startTime"));
                rental.setEndTime(rs.getTimestamp("endTime"));
                // Do something with the rental object, like printing its details
                System.out.println("Rental: " + rental);
            } else {
                System.out.println("Rental not found with id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Rental> getAllRentals() {
        List<Rental> rentalList = new ArrayList<>();
        String query = "SELECT * FROM Rentals";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Rental rental = new Rental();
                rental.setId(rs.getInt("id"));
                rental.setUserId(rs.getInt("userId"));
                rental.setBikeId(rs.getInt("bikeId"));
                rental.setStartTime(rs.getTimestamp("startTime"));
                rental.setEndTime(rs.getTimestamp("endTime"));
                rentalList.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalList;
    }

    @Override
    public void addRental(Rental rental) {
        String query = "INSERT INTO Rentals (userId, bikeId, startTime, endTime) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, rental.getUserId());
            statement.setInt(2, rental.getBikeId());
            statement.setTimestamp(3, rental.getStartTime());
            statement.setTimestamp(4, rental.getEndTime());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Rental added successfully.");
            } else {
                System.out.println("Failed to add rental.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRental(Rental rental) {
        String query = "UPDATE Rentals SET userId=?, bikeId=?, startTime=?, endTime=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, rental.getUserId());
            statement.setInt(2, rental.getBikeId());
            statement.setTimestamp(3, rental.getStartTime());
            statement.setTimestamp(4, rental.getEndTime());
            statement.setInt(5, rental.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Rental updated successfully.");
            } else {
                System.out.println("Failed to update rental.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRental(int id) {
        String query = "DELETE FROM Rentals WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Rental deleted successfully.");
            } else {
                System.out.println("Failed to delete rental.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
