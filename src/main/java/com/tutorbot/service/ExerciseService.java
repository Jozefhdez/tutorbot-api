package com.tutorbot.service;

import com.tutorbot.model.Exercise;
import com.tutorbot.model.Feedback;
import com.tutorbot.repository.ExerciseRepository;
import com.tutorbot.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepo;
    private final FeedbackRepository feedbackRepo;

    public ExerciseService(ExerciseRepository exerciseRepo, FeedbackRepository feedbackRepo) {
        this.exerciseRepo = exerciseRepo;
        this.feedbackRepo = feedbackRepo;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepo.findAll();
    }

    public List<Exercise> getExercisesByDifficulty(String difficulty) {
        return exerciseRepo.findAll().stream()
                .filter(e -> e.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }

    public Feedback submitAnswer(int studentId, int exerciseId, String answer) {
        Exercise ex = exerciseRepo.findById(exerciseId);

        if (ex == null) {
            return null;
        }

        String submittedAnswer = answer == null ? "" : answer.trim();
        String expectedAnswer = ex.getCorrectAnswer() == null ? "" : ex.getCorrectAnswer().trim();
        boolean isCorrect = expectedAnswer.equalsIgnoreCase(submittedAnswer);

        Feedback fb;
        if (isCorrect) {
            fb = new Feedback(studentId, exerciseId, answer, 100, "Correct.", true);
        } else {
            fb = new Feedback(studentId, exerciseId, answer, 40, "Not quite, keep trying!", false);
        }

        feedbackRepo.save(fb);
        return fb;
    }

    public List<Feedback> getFeedbackByStudent(int studentId) {
        return feedbackRepo.findByStudentId(studentId);
    }
}