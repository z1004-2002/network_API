package com.vetrix.network_API.fileManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FichierRepository extends JpaRepository<Fichier, UUID> {
}
