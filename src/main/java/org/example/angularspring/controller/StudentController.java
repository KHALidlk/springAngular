package org.example.angularspring.controller;

import org.example.angularspring.model.Student;
import org.example.angularspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello") // Ensure this matches the requested endpoint
public class StudentController {

    private final StudentService studentService;

    @Autowired // Injection par constructeur (meilleure pratique moderne)
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        System.out.println("StudentController instancié !");
    }
    @GetMapping("")
    public String hello() {
        return "Hello from StudentController!";
    }

    @GetMapping(path = "/students", produces = "application/json")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentService.findStudentById(id);
    }

    @PostMapping(value = "/add", consumes = "application/json;charset=UTF-8", produces = "application/json")
    public  String addStudent(@RequestBody Student student) {
        List<Student> students = studentService.getAllStudents();
        boolean found = false;
        found = students.stream()
                        .filter(p-> p.getEmail().equals(student.getEmail()))
                                .findAny()
                                        .isPresent();
if(found) {
    return "Student with email " + student.getEmail() + " already exists.";
} else {
    System.out.println("Student with email " + student.getEmail() + " does not exist. Adding new student.");
    studentService.addStudent(student);
    return "Student with email " + student.getEmail() + " added.";
}

    }


    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        System.out.println(student);
        studentService.updateStudent(student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);

    }


}

