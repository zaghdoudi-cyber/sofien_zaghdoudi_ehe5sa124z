package com.rest.scolarite.service.interfaces;

import com.rest.scolarite.model.IEtudiantProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEtudiantService {

    Page<IEtudiantProjection> getAllEtudiantsWithSearchedValue(String nomClasse, String nomEnseignant, Pageable pageable);

}
