/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.Post;
import com.vtl.service.MajorService;
import com.vtl.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private MajorService ms;
    
    
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
    
    @GetMapping("/Post/{postId}")
    public ResponseEntity<Post> listPost(@PathVariable int postId) {
        Post post = this.ps.getPostById(postId);
        return new ResponseEntity(post, HttpStatus.OK);
    }
    
    
    @GetMapping("/PostActive")
    public ResponseEntity<List<Post>> listActive() {
        List<Post> post = this.ps.getPostActive();
        
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    
//    @PreAuthorize("isAuthenticated()")
    @PostMapping(path = "/AddPost", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Post> addPost(@RequestParam Map<String, String> params, @RequestPart MultipartFile image) {
        Post post = this.ps.addPost(params, image);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    
    
     @GetMapping("/Account/{userId}")
    public ResponseEntity<List<Post>> listActive(@PathVariable int userId) {
        List<Post> post = this.ps.getPostByUserId(userId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    
    
    
}
