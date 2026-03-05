package com.tutorbot.repository;

import com.tutorbot.model.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(1, "Ana", "ana@tec.mx", "advanced"));
        students.add(new Student(2, "Jozef", "jozef@tec.mx", "intermediate"));
        students.add(new Student(3, "Baltazar", "baltazar@tec.mx", "intermediate"));
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Student student) {
        students.add(student);
    }
}