package com.tutorbot.repository;

import com.tutorbot.model.Feedback;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FeedbackRepository {
    private List<Feedback> submissions = new ArrayList<>();

    public void save(Feedback feedback) {
        submissions.add(feedback);
    }

    public List<Feedback> findByStudentId(int studentId) {
        return submissions.stream()
                .filter(f -> f.getStudentId() == studentId)
                .collect(Collectors.toList());
    }
}