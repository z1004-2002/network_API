package com.vetrix.network_API.ue;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UeRepository extends JpaRepository<Ue, UUID> {
}
