/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.repository;

import com.vtl.pojo.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thuy Linh
 */
public interface PostRepository {
    public List<Post> getPost(Map<String, String> params);
    public void addOrUpdatePost(Post p);
    public Post getPostById(int id);
    Post addPost(Post post);
    public void deletePost(int id);
    public List<Post> getPostActive(); 
    public List<Post> getPostByUserId(int userId);

}
