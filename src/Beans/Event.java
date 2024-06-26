package Beans;

import java.sql.Timestamp;

public class Event {
    private int id;
    private String name;
    private Timestamp date;
    private String description;

    // Constructors
    public Event() {}

    public Event(int id, String name, Timestamp date, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
