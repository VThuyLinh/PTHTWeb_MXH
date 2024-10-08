/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.service;

import com.vtl.pojo.Major;
import java.util.List;

/**
 *
 * @author Thuy Linh
 */
public interface MajorService {
    List<Major> getMajor();
    public Major getMajorById(int id);
    public Major getMajorByName(String name);
}
