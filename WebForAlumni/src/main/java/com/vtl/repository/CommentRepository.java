/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.repository;

import com.vtl.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thuy Linh
 */
public interface CommentRepository {
    public List<Comment> getComment(Map<String, String> params);
    public void deleteComment(int id);
    public Comment getCommentById(int id);
    public List<Comment> getListCommentByPostId(int postId);
    public Comment addComment (Comment cmt);
}
