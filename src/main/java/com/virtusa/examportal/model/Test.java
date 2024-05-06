package com.virtusa.examportal.model;

public class Test {
    private int id;
    private String title;
    private int duration; // Duration in minutes
    private int creatorId;

    public Test() {
    }

    public Test(int id, String title, int duration, int creatorId) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.creatorId = creatorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }
}
