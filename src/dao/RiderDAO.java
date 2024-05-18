package dao;

import Beans.Rider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RiderDAO implements RiderInterface {

    private Connection connection;

    public RiderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getRiderById(int id) {
        String query = "SELECT * FROM Riders WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Rider rider = new Rider();
                rider.setId(rs.getInt("id"));
                rider.setName(rs.getString("name"));
                rider.setDescription(rs.getString("description"));
                // Do something with the rider object, like printing its details
                System.out.println("Rider: " + rider);
            } else {
                System.out.println("Rider not found with id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Rider> getAllRiders() {
        List<Rider> riderList = new ArrayList<>();
        String query = "SELECT * FROM Riders";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Rider rider = new Rider();
                rider.setId(rs.getInt("id"));
                rider.setName(rs.getString("name"));
                rider.setDescription(rs.getString("description"));
                riderList.add(rider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return riderList;
    }

    @Override
    public void addRider(Rider rider) {
        String query = "INSERT INTO Riders (name, description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, rider.getName());
            statement.setString(2, rider.getDescription());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Rider added successfully.");
            } else {
                System.out.println("Failed to add rider.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRider(Rider rider) {
        String query = "UPDATE Riders SET name=?, description=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, rider.getName());
            statement.setString(2, rider.getDescription());
            statement.setInt(3, rider.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Rider updated successfully.");
            } else {
                System.out.println("Failed to update rider.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRider(int id) {
        String query = "DELETE FROM Riders WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Rider deleted successfully.");
            } else {
                System.out.println("Failed to delete rider.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
