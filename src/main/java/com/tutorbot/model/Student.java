package com.tutorbot.model;

public class Student {
    private Integer id;
    private String name;
    private String email;
    private String level;

    public Student() {}

    public Student(Integer id, String name, String email, String level) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.level = level;
    }

    // getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}