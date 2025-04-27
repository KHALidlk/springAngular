package org.example.angularspring.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

import java.util.List;
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Le nom est requis")
    @Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
    private String name;
    @NotBlank(message = "L'email est requis")
    @Email(message = "L'email doit être valide")
    private String email;
    private String password;
    private String apogee;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "student_notes", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "note")
    private List<Double> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApogee() {
        return apogee;
    }

    public void setApogee(String apogee) {
        this.apogee = apogee;
    }

    public List<Double> getNotes() {
        return notes;
    }

    public void setNotes(List<Double> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", apogee='" + apogee + '\'' +
                ", notes=" + notes +
                '}';
    }
}
