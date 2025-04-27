package org.example.angularspring.service;

import org.example.angularspring.model.Student;
import org.example.angularspring.repository.StudentRepoIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepoIml studentRepo;
    @Autowired
    public StudentService(StudentRepoIml studentRepo) {
        this.studentRepo = studentRepo;
    }
    public void addStudent(Student student) {
        studentRepo.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    public Student findStudentById(int id) {
        return studentRepo.findStudentById(id);
    }
    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }
    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);
    }


    public StudentRepoIml getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepoIml studentRepo) {
        this.studentRepo = studentRepo;
    }
}