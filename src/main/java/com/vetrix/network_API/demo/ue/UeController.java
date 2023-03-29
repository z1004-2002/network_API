package com.vetrix.network_API.demo.ue;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/ue")
@Tag(name = "Test Ue")
public class UeController {
    private final UeService ueService;
    @Autowired
    public UeController(UeService ueService) {
        this.ueService = ueService;
    }

    @PostMapping("/add/{id}")
    public void addUd(@PathVariable UUID id,@RequestBody Ue ue){
        ueService.addUe(ue,id);
    }
    @GetMapping
    public List<Ue> getUe(){
        return ueService.getUe();
    }
    @GetMapping("/{id}")
    public Optional<Ue> getUeById(@PathVariable UUID id){
        return ueService.getUeById(id);
    }
}
