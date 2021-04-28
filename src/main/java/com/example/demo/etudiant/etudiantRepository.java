package com.example.demo.etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface etudiantRepository
        extends JpaRepository<etudiant, Long> {
    @Query("SELECT s FROM etudiant s WHERE s.email=?1")
    Optional<etudiant> findetudiantByEmail(String email);
}
