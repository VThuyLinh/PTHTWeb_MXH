/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Major;
import com.vtl.repository.MajorRepository;
import com.vtl.service.MajorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class MajorServiceImpl implements MajorService {
    
    @Autowired
    private MajorRepository mr;
    
    @Override
    public List<Major> getMajor() {
        return this.mr.getMajor();
    }
    
}
