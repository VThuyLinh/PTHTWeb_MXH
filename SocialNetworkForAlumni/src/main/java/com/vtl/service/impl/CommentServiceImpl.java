/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Comment;
import com.vtl.repository.CommentRepository;
import com.vtl.service.CommentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository cs;

    @Override
    public List<Comment> getComment(Map<String, String> params) {
        return cs.getComment(params);

    }

    @Override
    public void deleteComment(int id) {
        this.cs.deleteComment(id);
    }
}
