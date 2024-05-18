package dao;

import Beans.Bike;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class BikeDAO implements BikeInterface {

    private Connection connection;

    public BikeDAO(Connection connection) {
        this.connection = connection;
    }

    public BikeDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void getBikeById(int id) {
        String query = "SELECT * FROM Bikes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Bike bike = new Bike();
                bike.setId(rs.getInt("id"));
                bike.setName(rs.getString("name"));
                bike.setDescription(rs.getString("description"));
                bike.setAvailable(rs.getBoolean("isAvailable"));
                bike.setAvailableTime(rs.getTimestamp("availableTime"));
                // Do something with the bike object, like printing its details
                System.out.println("Bike: " + bike);
            } else {
                System.out.println("Bike not found with id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bike> getAllBikes() {
        List<Bike> bikes = new ArrayList<>();
        String query = "SELECT * FROM bikes";

        try (Connection connection = DatabaseConnection.createConnection();
             java.sql.Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Bike bike = new Bike();
                bike.setId(resultSet.getInt("id"));
                bike.setName(resultSet.getString("name"));
                bike.setDescription(resultSet.getString("description"));
                bike.setImageUrl(resultSet.getString("imageUrl"));
                bike.setAvailable(resultSet.getBoolean("available"));
                bikes.add(bike);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bikes;
    }

    @Override
    public void addBike(Bike bike) {
        String query = "INSERT INTO Bikes (name, description, isAvailable, availableTime) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bike.getName());
            statement.setString(2, bike.getDescription());
            statement.setBoolean(3, bike.isAvailable());
            statement.setTimestamp(4, bike.getAvailableTime());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Bike added successfully.");
            } else {
                System.out.println("Failed to add bike.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBike(Bike bike) {
        String query = "UPDATE Bikes SET name=?, description=?, isAvailable=?, availableTime=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bike.getName());
            statement.setString(2, bike.getDescription());
            statement.setBoolean(3, bike.isAvailable());
            statement.setTimestamp(4, bike.getAvailableTime());
            statement.setInt(5, bike.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Bike updated successfully.");
            } else {
                System.out.println("Failed to update bike.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBike(int id) {
        String query = "DELETE FROM Bikes WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Bike deleted successfully.");
            } else {
                System.out.println("Failed to delete bike.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
