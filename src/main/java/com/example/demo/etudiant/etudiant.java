package com.example.demo.etudiant;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class etudiant {
    @Id
    @SequenceGenerator(
            name="etudiant_sequence",
            sequenceName = "etudiant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "etudiant_sequence"
    )
    private Long id;
    private String nom;
    private String email;
    private LocalDate dateNaissance;
    @Transient
    private int age;

    public etudiant() {
    }

    public etudiant(Long id, String nom, String email, LocalDate dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.dateNaissance = dateNaissance;
    }

    public etudiant(String nom, String email, LocalDate dateNaissance) {
        this.nom = nom;
        this.email = email;
        this.dateNaissance = dateNaissance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getAge() {

        return Period.between(dateNaissance,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", age=" + age +
                '}';
    }
}
