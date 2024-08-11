/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.service;

import com.vtl.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thuy Linh
 */
public interface CommentService {
    public List<Comment> getComment(Map<String, String> params);
}
