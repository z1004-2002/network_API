package com.vetrix.network_API.project.file;

import com.vetrix.network_API.demo.fileManager.Fichier;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@Tag(name = "File")
@CrossOrigin("*")
public class FileController {
    private final FileRepository repository;
    private final FileService service;

    public FileController(FileRepository repository, FileService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<FileResponse> getInfo(){
        return service.getInfo();
    }

    @GetMapping("/{id}")
    public Optional<FileResponse> getInfoById(@PathVariable UUID id){
        return service.getInfoById(id);
    }

    @PostMapping("/upload/{sender}/to/{reciever}")
    public FileResponse uploadFile(
            @PathVariable String sender,
            @PathVariable String reciever,
            @RequestParam("file") MultipartFile file
            ) throws IOException {
        return service.uploadFile(file, sender, reciever);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFichier(@PathVariable UUID id) {
        Optional<FileResponse> fileOptional = repository.findById(id);

        if (fileOptional.isPresent()) {
            FileResponse fileEntity = fileOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                    .body(fileEntity.getContent());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("info/{sender}")
    public List<FileResponse> getBySenderOrReciever(@PathVariable String sender/*, @PathVariable String reciever*/){
        return service.getBySenderOrReciever(sender/*,reciever*/);
    }
}
