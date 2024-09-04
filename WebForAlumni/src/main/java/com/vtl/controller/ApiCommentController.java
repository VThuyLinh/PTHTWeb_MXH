/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.Comment;
import com.vtl.service.CommentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class ApiCommentController {
    @Autowired
    private CommentService cs;
    @DeleteMapping("/Comment/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value="commentId") int id)
    {
        this.cs.deleteComment(id);
    }
    
    
    @GetMapping("/Comment")
    public ResponseEntity<List<Comment>> list(@RequestParam Map<String, String> params) {
        List<Comment> cmt = this.cs.getComment(params);
        
        return new ResponseEntity<>(cmt, HttpStatus.OK);
    }
    
    @GetMapping("/Comment/{postId}")
    public ResponseEntity<List<Comment>> list(@PathVariable int postId) {
        List<Comment> cmt = this.cs.getListCommentByPostId(postId);
        
        return new ResponseEntity<>(cmt, HttpStatus.OK);
    }
    
    
    @PostMapping(path = "/AddComment/{postId}", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Comment> addComment(@RequestParam Map<String, String> params, @RequestPart MultipartFile image) {
        Comment cmt = this.cs.addComment(params, image);
        return new ResponseEntity<>(cmt, HttpStatus.CREATED);
    }
}
