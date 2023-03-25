package com.vetrix.network_API.ue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UeRepository extends JpaRepository<Ue, UUID> {
}
