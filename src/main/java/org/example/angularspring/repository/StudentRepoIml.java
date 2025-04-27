package org.example.angularspring.repository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import org.example.angularspring.model.Student;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
@ComponentScan(basePackages = "org.example.angularspring")
public class StudentRepoIml implements StudentRepo {

    @PersistenceUnit
    private EntityManagerFactory emf;

    private EntityManager em;

    @PostConstruct
    public void init() {
        // Get EntityManager to verify connection
        em = emf.createEntityManager();
        System.out.println("Connexion OK : " + em.isOpen());
        em.close();
    }

    public void addStudent(Student student) {
        em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

    public Student findStudentById(int id) {
        em = emf.createEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }



    public List<Student> getAllStudents() {
        em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void updateStudent(Student student) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public void deleteStudent(int id) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
