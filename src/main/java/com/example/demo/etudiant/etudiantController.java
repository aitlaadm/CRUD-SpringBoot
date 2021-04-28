package com.example.demo.etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/etudiant")
public class etudiantController {
    private final etudiantService etuServ;
    @Autowired
    public etudiantController(etudiantService etuServ){
        this.etuServ=etuServ;
    }
    @GetMapping
    public List<etudiant> getEtudiants(){
        return etuServ.getEtudiant();
    }
    @PostMapping
    public void enregistrerEtudiant(@RequestBody etudiant etu){
        etuServ.ajouterNouveauEtudiant(etu);
    }
    @DeleteMapping(path="{id}")
    public void supprimerEtudiant(@PathVariable("id") Long id){
            etuServ.supprimer(id);
    }
    @PutMapping(path = "{id}")
    public void modifierEtudiant(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate dateNAissance
    ){
        etuServ.modifier(id,nom,email,dateNAissance);
    }
}
