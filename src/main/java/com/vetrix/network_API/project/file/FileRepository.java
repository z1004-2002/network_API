package com.vetrix.network_API.project.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<FileResponse, UUID> {
    @Query("select f from FileResponse f where f.sender = ?1 or f.reciever = ?1")
    List<FileResponse> getBySenderOrReciever(String sender/*, String reciever*/);

    @Query("select f from FileResponse f where f.reciever = ?1")
    List<FileResponse> getByReciever(String sender);
}
