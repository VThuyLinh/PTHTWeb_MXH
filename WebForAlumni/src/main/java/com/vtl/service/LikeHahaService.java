/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.service;

import com.vtl.pojo.LikeHaha;
import java.util.List;

/**
 *
 * @author tlinh
 */
public interface LikeHahaService {
    
     public Long getCountLikeonPost(int post) ; 
    public LikeHaha addLike (LikeHaha like); 
    public List<LikeHaha> getAllLikeByPostId(int postId);
    public void addOrUpdateLike(LikeHaha l);
}
