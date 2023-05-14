package com.rest.scolarite.domaine;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "etudiants")
public class Etudiant extends Personne {

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

}
