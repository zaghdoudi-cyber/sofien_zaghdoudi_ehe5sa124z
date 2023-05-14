package com.rest.scolarite.web.resource;

import com.rest.scolarite.model.IEtudiantProjection;
import com.rest.scolarite.service.implementation.EtudiantServiceImpl;
import com.rest.scolarite.service.interfaces.IEtudiantService;
import com.rest.scolarite.web.utils.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantResource {

    final private IEtudiantService IEtudiantService;
    private static final Logger log = LoggerFactory.getLogger(EtudiantServiceImpl.class);

    public EtudiantResource(IEtudiantService IEtudiantService) {
        this.IEtudiantService = IEtudiantService;
    }

    @GetMapping("/search")
    public ResponseEntity getAllEtudiantsWithSearchedValue(@RequestParam String nomClasse, @RequestParam String nomEnseignant, Pageable pageable) {
        Page<IEtudiantProjection> etudiants = IEtudiantService.getAllEtudiantsWithSearchedValue(nomClasse, nomEnseignant, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(etudiants, "/api/etudiants/search");
        return new ResponseEntity<>(etudiants.getContent(), headers, HttpStatus.OK);
    }

}
