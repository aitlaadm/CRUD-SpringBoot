package com.example.demo.etudiant;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class etudiantService {
    private final etudiantRepository etudiantRepository;

    public etudiantService(com.example.demo.etudiant.etudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<etudiant> getEtudiant(){
        return etudiantRepository.findAll();
    }
    public void ajouterNouveauEtudiant(etudiant etu){
        Optional<etudiant> etudiantParEmail = this.etudiantRepository.findetudiantByEmail(etu.getEmail());
        if(etudiantParEmail.isPresent()){
            throw new IllegalStateException("Email Déjà utilisé");
        }
        this.etudiantRepository.save(etu);
    }
    public void supprimer(Long id){
        boolean exist = etudiantRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException(("aucun etudiant avec l'id "+id));
        }
        etudiantRepository.deleteById(id);
    }
    @Transactional
    public void modifier(Long id, String nom, String email, LocalDate dateNAissance){
            etudiant etu = etudiantRepository.findById(id).orElseThrow(()->
                    new IllegalStateException("aucun etudiant avec l'id "+id));
            if(nom!=null&&nom.length()>0&&!Objects.equals(etu.getNom(),nom)){
                etu.setNom(nom);
            }
            if(email!=null&&email.length()>0&&!Objects.equals(etu.getEmail(),email)){
                Optional<etudiant> etudiantOptional= etudiantRepository.findetudiantByEmail(email);
                if(etudiantOptional.isPresent()){
                    throw new IllegalStateException("email déjà utilisé");
                }
                etu.setEmail(email);
            }
            if(dateNAissance!=null&&!Objects.equals(etu.getDateNaissance(),dateNAissance)){
                etu.setDateNaissance(dateNAissance);
            }
    }
}
