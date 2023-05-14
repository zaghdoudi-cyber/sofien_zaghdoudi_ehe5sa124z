package com.rest.scolarite.service.implementation;

import com.rest.scolarite.domaine.Etudiant;
import com.rest.scolarite.model.IEtudiantProjection;
import com.rest.scolarite.repository.EtudiantRepository;
import com.rest.scolarite.service.interfaces.IEtudiantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {
    private static final Logger log = LoggerFactory.getLogger(EtudiantServiceImpl.class);

    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public Page<IEtudiantProjection> getAllEtudiantsWithSearchedValue(String nomClasse, String nomEnseignant, Pageable pageable) {
        Page<IEtudiantProjection> etudiants = etudiantRepository.findEtudiantssWithSearchedValue(nomClasse, nomEnseignant, pageable);
        if (!etudiants.isEmpty()) {
            return etudiants;
        } else {
            return etudiantRepository.findAllEtudiants(pageable);
        }
    }
}
