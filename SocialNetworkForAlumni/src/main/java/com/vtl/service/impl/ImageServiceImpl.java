/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Image;
import com.vtl.repository.ImageRepository;
import com.vtl.service.ImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository ir;

    @Override
     public List<Object> getImageByPostId(int postId) {
        return this.ir.getImageByPostId(postId);
    }

    
   
    
}
