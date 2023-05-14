package com.rest.scolarite.repository;

import com.rest.scolarite.domaine.Etudiant;
import com.rest.scolarite.model.IEtudiantProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Query(value = "select e.id, e.prenom, e.nom_famille as nomFamille from etudiants as e left join classes as c on e.classe_id = c.id " +
            "left join enseignants as p on p.id = c.enseignant_id " +
            "where (c.nom like :nomClasse " +
            "or " +
            "CONCAT(p.prenom, ' ', p.nom_famille) like  :nomProf) ", nativeQuery = true)
    Page<IEtudiantProjection> findEtudiantssWithSearchedValue(@Param("nomClasse") String nomClasse, @Param("nomProf") String nomProf, Pageable pageable);

    @Query(value = "select e.id, e.prenom, e.nom_famille as nomFamille from etudiants as e ", nativeQuery = true)
    Page<IEtudiantProjection> findAllEtudiants(Pageable pageable);
}