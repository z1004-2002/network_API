package com.vetrix.network_API.project.file;

import com.vetrix.network_API.project.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {

    private final FileRepository repository;
    private final PersonRepository personRepository;
    @Autowired
    public FileService(FileRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public FileResponse uploadFile(MultipartFile file,String sender,String reciever) throws IOException {
        FileResponse fileResponse = new FileResponse();
        /*if(
                personRepository.getByPhone(sender).size() == 0
                        || personRepository.getByPhone(reciever).size() == 0
        ){
            throw new IllegalStateException("Not found Sender or reciever ");
        }*/

        fileResponse.setSender(sender);
        fileResponse.setReciever(reciever);
        fileResponse.setName(file.getOriginalFilename());
        fileResponse.setType(file.getContentType());
        fileResponse.setContent(file.getBytes());
        fileResponse = repository.save(fileResponse);
        return fileResponse;
    }

    public Optional<FileResponse> getInfoById(UUID id){
        return repository.findById(id);
    }
    public List<FileResponse> getInfo(){
        return repository.findAll();
    }

    public List<FileResponse> getBySenderOrReciever(String sender/*,String reciever*/){
        return repository.getBySenderOrReciever(sender/*, reciever*/);
    }
}
