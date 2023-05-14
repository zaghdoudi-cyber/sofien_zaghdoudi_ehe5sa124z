package com.rest.scolarite.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "classes")
public class Classe extends AbstractAuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASSE_SEQ")
    @SequenceGenerator(name = "CLASSE_SEQ", sequenceName = "classe_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nom")
    @NotBlank(message = "nom de classe ne doit pas être nulle ou vide")
    @Size(min = 3, max = 150, message = "nom de classe doit être compris entre 3 et 150 caractères")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    @JsonIgnore
    private Enseignant enseignant;

    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private Set<Etudiant> etudiants = new HashSet<>();
}
