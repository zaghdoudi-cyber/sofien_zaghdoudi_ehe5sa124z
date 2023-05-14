package com.rest.scolarite.domaine;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "enseignants")
public class Enseignant extends Personne {

    @OneToMany(mappedBy = "enseignant", fetch = FetchType.LAZY)
    private Set<Classe> classes = new HashSet<>();
}
