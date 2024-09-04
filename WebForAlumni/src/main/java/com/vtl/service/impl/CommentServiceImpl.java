/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vtl.pojo.Comment;
import com.vtl.repository.CommentRepository;
import com.vtl.repository.UserRepository;
import com.vtl.service.CommentService;
import com.vtl.service.PostService;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thuy Linh
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository cr;
    @Autowired
    private PostService ps;
    @Autowired
    private UserRepository ur;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Comment> getComment(Map<String, String> params) {
        return cr.getComment(params);

    }

    @Override
    public void deleteComment(int id) {
        this.cr.deleteComment(id);
    }

    @Override
     public Comment getCommentById(int id){
        return this.cr.getCommentById(id);
    }

    @Override
    public List<Comment> getListCommentByPostId(int postId) {
        return this.cr.getListCommentByPostId(postId);
    }
    
    @Override
    public Comment addComment(Map<String, String> params, MultipartFile image) {
        Comment c = new Comment();
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        c.setContent(params.getOrDefault("content", ""));
        c.setPostId(ps.getPostById(Integer.parseInt(params.get("postId"))));
        c.setUserId(ur.getUserByUsername(params.get("userid")));
        c.setCreatedDate(timestamp);
        c.setActive(Boolean.TRUE);
        if (!image.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(image.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                c.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            c.setImage(params.getOrDefault("image", ""));
        }
        

        this.cr.addComment(c);
        return c;
    }
}
