package org.example.angularspring.repository;
import org.example.angularspring.model.Student;
import java.util.List;
public interface StudentRepo {
    public void addStudent(Student student);
    public List<Student> getAllStudents() ;
    public Student findStudentById(int id);
    public void deleteStudent(int id);
    public void updateStudent(Student student);
}