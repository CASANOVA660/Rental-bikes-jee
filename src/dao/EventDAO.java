package dao;

import Beans.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO implements EventInterface {

    private Connection connection;

    public EventDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getEventById(int id) {
        String query = "SELECT * FROM Events WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("name"));
                event.setDate(rs.getTimestamp("date"));
                event.setDescription(rs.getString("description"));
                // Do something with the event object, like printing its details
                System.out.println("Event: " + event);
            } else {
                System.out.println("Event not found with id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> eventList = new ArrayList<>();
        String query = "SELECT * FROM Events";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("name"));
                event.setDate(rs.getTimestamp("date"));
                event.setDescription(rs.getString("description"));
                eventList.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    @Override
    public void addEvent(Event event) {
        String query = "INSERT INTO Events (name, date, description) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, event.getName());
            statement.setTimestamp(2, event.getDate());
            statement.setString(3, event.getDescription());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Event added successfully.");
            } else {
                System.out.println("Failed to add event.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEvent(Event event) {
        String query = "UPDATE Events SET name=?, date=?, description=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, event.getName());
            statement.setTimestamp(2, event.getDate());
            statement.setString(3, event.getDescription());
            statement.setInt(4, event.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Event updated successfully.");
            } else {
                System.out.println("Failed to update event.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(int id) {
        String query = "DELETE FROM Events WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Event deleted successfully.");
            } else {
                System.out.println("Failed to delete event.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
