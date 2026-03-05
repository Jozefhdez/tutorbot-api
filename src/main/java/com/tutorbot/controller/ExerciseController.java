package com.tutorbot.controller;

import com.tutorbot.model.Exercise;
import com.tutorbot.model.Feedback;
import com.tutorbot.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {
    private final ExerciseService service;

    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Exercise> getExercises(@RequestParam(required = false) String difficulty) {
        if (difficulty != null) {
            return service.getExercisesByDifficulty(difficulty);
        }
        return service.getAllExercises();
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitAnswer(@RequestBody Map<String, Object> payload) {
        int studentId = (int) payload.get("studentId");
        int exerciseId = (int) payload.get("exerciseId");
        String answer = (String) payload.get("answer");

        Feedback result = service.submitAnswer(studentId, exerciseId, answer);
        if (result == null) {
            return ResponseEntity.status(404).body("Exercise with ID " + exerciseId + " not found.");
        }
        return ResponseEntity.ok(result);
    }
}