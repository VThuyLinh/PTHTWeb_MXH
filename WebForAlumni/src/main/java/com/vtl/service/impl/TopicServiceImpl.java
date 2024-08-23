/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Topic;
import com.vtl.repository.TopicRepository;
import com.vtl.service.TopicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicRepository tr;
    @Override
    public List<Topic> getAllTopic() {
        return this.tr.getAllTopic();
    }

    @Override
    public Topic getTopicById(int id) {
       return this.tr.getTopicById(id);
    }
    
}
