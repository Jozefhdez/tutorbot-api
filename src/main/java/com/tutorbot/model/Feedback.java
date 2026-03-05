package com.tutorbot.model;

public class Feedback {
    private int studentId;
    private int exerciseId;
    private String answer;
    private int score;
    private String message;
    private boolean correct;

    public Feedback() {}

    public Feedback(int studentId, int exerciseId, String answer, int score, String message, boolean correct) {
        this.studentId = studentId;
        this.exerciseId = exerciseId;
        this.answer = answer;
        this.score = score;
        this.message = message;
        this.correct = correct;
    }

    // getters and setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getExerciseId() { return exerciseId; }
    public void setExerciseId(int exerciseId) { this.exerciseId = exerciseId; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isCorrect() { return correct; }
    public void setCorrect(boolean correct) { this.correct = correct; }
}