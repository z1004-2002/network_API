package com.vetrix.network_API.demo.topic;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Tag(name = "Test Topic")
@RequestMapping("/topic")
@CrossOrigin("*")
public class TopicController {
    private final TopicService topicService;
    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }
    @GetMapping
    public List<Topic> getTopic(){
        return topicService.getTopic();
    }
    @GetMapping("/{id}")
    public Optional<Topic> getTopicById(@PathVariable UUID id){
        return topicService.findTopicById(id);
    }
    @PostMapping("/add")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }
}
