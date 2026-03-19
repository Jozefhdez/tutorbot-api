package com.tutorbot.service;

import com.tutorbot.model.Student;
import com.tutorbot.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id);
    }

    public Student registerStudent(Student s) {
        int nextId = repository.findAll().size() + 1;
        s.setId(nextId);
        repository.save(s);
        return s;
    }
}