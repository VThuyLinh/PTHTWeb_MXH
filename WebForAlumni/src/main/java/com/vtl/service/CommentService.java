/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.service;

import com.vtl.pojo.Comment;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thuy Linh
 */
public interface CommentService {
    public List<Comment> getComment(Map<String, String> params);
    public void deleteComment(int id);
    public Comment getCommentById(int id);
    public List<Comment> getListCommentByPostId(int postId);
    public Comment addComment(Map<String, String> params, MultipartFile image);
}
