/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Post;
import com.vtl.repository.PostRepository;
import com.vtl.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository pr;

    @Override
    public List<Post> getPost(Map<String, String> params) {
       return pr.getPost(params);
    }

    @Override
    public void addOrUpdatePost(Post p) {
       pr.addOrUpdatePost(p);
    }

    @Override
    public Post getPostById(int id) {
        return pr.getPostById(id);
    }

    @Override
    public void deletePost(int id) {
        this.pr.deletePost(id);
    }

//    @Override
//    public void updateActivePost(int id) {
//      this.pr.updateActivePost(id);
//    }

    
}
