/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vtl.pojo.Post;
import com.vtl.repository.PostRepository;
import com.vtl.service.PostService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Post> getPost(Map<String, String> params) {
       return pr.getPost(params);
    }

    @Override
    public void addOrUpdatePost(Post p) {
        
        if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(PostServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    @Override
    public List<Post> getPostActive() {
        
        return this.pr.getPostActive();
    }



    
}
