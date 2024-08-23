/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.Post;
import com.vtl.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thuy Linh
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiPostController {
    
    @Autowired
    private PostService ps;
    @DeleteMapping("/Post/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value="postId") int id)
    {
        this.ps.deletePost(id);
    }
    
    
    @GetMapping("/Post")
    public ResponseEntity<List<Post>> list(@RequestParam Map<String, String> params) {
        List<Post> post = this.ps.getPost(params);
        
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    
    
    
}
