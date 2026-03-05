package com.tutorbot.controller;

import com.tutorbot.model.Feedback;
import com.tutorbot.model.Student;
import com.tutorbot.service.ExerciseService;
import com.tutorbot.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final ExerciseService exerciseService;

    public StudentController(StudentService studentService, ExerciseService exerciseService) {
        this.studentService = studentService;
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        studentService.registerStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.status(404).body("Student with ID " + id + " not found.");
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<List<Feedback>> getStudentFeedback(@PathVariable int id) {
        List<Feedback> feedback = exerciseService.getFeedbackByStudent(id);
        return ResponseEntity.ok(feedback);
    }
}