package dao;

import Beans.Event;
import java.util.List;

public interface EventInterface {
    void getEventById(int id);
    List<Event> getAllEvents();
    void addEvent(Event event);
    void updateEvent(Event event);
    void deleteEvent(int id);
}
