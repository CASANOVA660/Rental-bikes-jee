package Beans;

import java.sql.Timestamp;

public class Bike {
    private int id;
    private String name;
    private String description;
    private String imageUrl;  // Added imageUrl field
    private boolean isAvailable;
    private Timestamp availableTime;

    // Constructors
    public Bike() {}

    public Bike(int id, String name, String description, String imageUrl, boolean isAvailable, Timestamp availableTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isAvailable = isAvailable;
        this.availableTime = availableTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Timestamp getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Timestamp availableTime) {
        this.availableTime = availableTime;
    }}