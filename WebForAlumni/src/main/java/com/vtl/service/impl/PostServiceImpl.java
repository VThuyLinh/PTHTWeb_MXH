/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vtl.pojo.Post;
import com.vtl.repository.PostRepository;
import com.vtl.repository.UserRepository;
import com.vtl.service.MajorService;
import com.vtl.service.PostService;
import com.vtl.service.TopicService;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thuy Linh
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository pr;
    @Autowired
    private MajorService ms;
    @Autowired
    private TopicService ts;
    @Autowired
    private UserRepository ur;

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
//        Date now = new Date();
//        Timestamp timestamp = new Timestamp(now.getTime());
//        p.setCreatedDate(timestamp);
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

    @Override
    public List<Post> getPostByUserId(int userId) {
        return this.pr.getPostByUserId(userId);
    }

    @Override
    public Post addPost(Map<String, String> params, MultipartFile image) {
        Post p = new Post();
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        p.setContent(params.getOrDefault("content", ""));
        p.setMajoridforPost(ms.getMajorById(Integer.parseInt(params.get("majoridforPost"))));
        p.setTopicidforPost(ts.getTopicById(Integer.parseInt(params.getOrDefault("topicidforPost", "1"))));
        p.setUseridforPost(ur.getUserByUsername(params.get("userid")));
        p.setCreatedDate(timestamp);
        if (!image.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(image.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.pr.addPost(p);
        return p;
    }

}
