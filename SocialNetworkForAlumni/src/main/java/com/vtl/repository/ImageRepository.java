/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.repository;

import com.vtl.pojo.Image;
import java.util.List;

/**
 *
 * @author Thuy Linh
 */

public interface ImageRepository {
     public List<Object> getImageByPostId(int postId);
     
}
