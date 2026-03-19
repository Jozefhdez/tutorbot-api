package com.tutorbot.repository;

import com.tutorbot.model.Exercise;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExerciseRepository {
    private List<Exercise> exercises = new ArrayList<>();

    public ExerciseRepository() {
        exercises.add(new Exercise(1, "Spring Boot", "What annotation marks a REST controller?", "easy", "@RestController"));
        exercises.add(new Exercise(2, "Java", "Which keyword is used to inherit a class?", "easy", "extends"));
        exercises.add(new Exercise(3, "C", "What operator is used to get the address of a variable?", "medium", "&"));
        exercises.add(new Exercise(4, "Assembly", "Which register is the accumulator in x86?", "hard", "eax"));
    }

    public List<Exercise> findAll() {
        return exercises;
    }

    public Exercise findById(int id) {
        return exercises.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}