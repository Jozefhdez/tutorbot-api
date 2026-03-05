package com.tutorbot.model;

public class Exercise {
    private int id;
    private String topic;
    private String question;
    private String difficulty;

    public Exercise() {}

    public Exercise(int id, String topic, String question, String difficulty) {
        this.id = id;
        this.topic = topic;
        this.question = question;
        this.difficulty = difficulty;
    }

    // getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
}