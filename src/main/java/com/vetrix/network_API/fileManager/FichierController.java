package com.vetrix.network_API.fileManager;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@Tag(name = "File Manager")
@CrossOrigin("*")
public class FichierController {
    @Autowired
    private FichierRepository fichierRepository;

    @PostMapping("/upload")
    public Fichier uploadFichier(@RequestParam("file") MultipartFile file) throws IOException {
        Fichier fichierEntite = new Fichier();
        fichierEntite.setNom(file.getOriginalFilename());
        fichierEntite.setType(file.getContentType());
        fichierEntite.setContenu(file.getBytes());
        fichierEntite = fichierRepository.save(fichierEntite);
        return fichierEntite;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFichier(@PathVariable UUID id) {
        Optional<Fichier> fichierOptional = fichierRepository.findById(id);
        if (fichierOptional.isPresent()) {
            Fichier fichierEntite = fichierOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fichierEntite.getNom() + "\"")
                    .body(fichierEntite.getContenu());
        }
        return ResponseEntity.notFound().build();
    }
}
