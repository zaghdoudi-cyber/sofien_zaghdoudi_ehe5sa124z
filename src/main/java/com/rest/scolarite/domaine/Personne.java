package com.rest.scolarite.domaine;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@MappedSuperclass
public class Personne extends AbstractAuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONNE_SEQ")
    @SequenceGenerator(name = "PERSONNE_SEQ", sequenceName = "personne_seq", allocationSize = 1)
    private Long id;

    @Column(name = "prenom")
    @NotBlank(message = "prénom ne doit pas être null ou vide")
    @Size(min = 3, max = 100, message = "prénom doit être compris entre 3 et 100 caractères")
    private String prenom;

    @Column(name = "nom_famille")
    @NotBlank(message = "nom de famille ne doit pas être nulle ou vide")
    @Size(min = 3, max = 150, message = "nom de famille doit être compris entre 3 et 150 caractères")
    private String nomFamille;
}
