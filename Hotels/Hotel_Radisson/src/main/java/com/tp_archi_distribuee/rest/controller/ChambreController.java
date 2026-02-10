package com.tp_archi_distribuee.rest.controller;

import com.tp_archi_distribuee.rest.model.Chambre;
import com.tp_archi_distribuee.rest.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @PostMapping("/{id}/image")
    public ResponseEntity<?> uploadImage(
            @PathVariable int id,
            @RequestParam("file") MultipartFile file) {

        try {
            Chambre updatedChambre = chambreService.setImageChambre(id, file);
            return ResponseEntity.ok(updatedChambre);
        } catch (IOException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors du traitement de l'image");
        }
    }
}
