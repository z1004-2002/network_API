package com.vetrix.network_API.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TopicService {
    private final TopicRepository topicRepository;
    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public Optional<Topic> findTopicById(UUID id){
        return topicRepository.findById(id);
    }

    public List<Topic> getTopic(){
        return topicRepository.findAll();
    }
}
