package com.vetrix.network_API.demo.ue;

import com.vetrix.network_API.demo.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UeService {
    private final UeRepository ueRepository;
    private final TopicRepository topicRepository;
    @Autowired
    public UeService(UeRepository ueRepository, TopicRepository topicRepository) {
        this.ueRepository = ueRepository;
        this.topicRepository = topicRepository;
    }

    public List<Ue> getUe(){
        return ueRepository.findAll();
    }
    public Optional<Ue> getUeById(UUID id){
        return ueRepository.findById(id);
    }
    public void addUe(Ue ue,UUID id){
        topicRepository.findById(id).map(topic -> {
            ue.setTopic(topic);
            return ueRepository.save(ue);
        }).orElseThrow(()->new IllegalStateException("Topic not found"));
    }
}
