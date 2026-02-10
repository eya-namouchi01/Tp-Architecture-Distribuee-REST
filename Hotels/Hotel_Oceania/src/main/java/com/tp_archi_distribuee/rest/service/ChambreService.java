package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.exception.ChambreException;
import com.tp_archi_distribuee.rest.model.Chambre;
import com.tp_archi_distribuee.rest.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ChambreService {
    @Autowired
    ChambreRepository chambreRepo;

    public Chambre setImageChambre(int id, MultipartFile file) throws IOException {
        Chambre chambre = chambreRepo.findById(id)
                .orElseThrow(() ->
                        new ChambreException("Aucune chambre avec cet identifiant"));

        chambre.setImg(file.getBytes());
        return chambreRepo.save(chambre);
    }


}
