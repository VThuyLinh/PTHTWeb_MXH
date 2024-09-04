/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vtl.pojo.Comment;
import com.vtl.pojo.LikeHaha;
import com.vtl.repository.CommentRepository;
import com.vtl.repository.LikeHahaRepository;
import com.vtl.repository.UserRepository;
import com.vtl.service.CommentService;
import com.vtl.service.LikeHahaService;
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
public class LikeHahaServiceImpl implements LikeHahaService {

    @Autowired
    private LikeHahaRepository lr;
    
    @Override
    public Long getCountLikeonPost(int post) {
       return this.lr.getCountLikeonPost(post);
    }

    @Override
    public LikeHaha addLike(LikeHaha like) {
        return this.lr.addLike(like);
    }

    @Override
     public List<LikeHaha> getAllLikeByPostId(int postId) {
       return this.lr.getAllLikeByPostId(postId);
    }

    @Override
    public void addOrUpdateLike(LikeHaha l) {
        lr.addOrUpdateLike(l);
    }

    
}
