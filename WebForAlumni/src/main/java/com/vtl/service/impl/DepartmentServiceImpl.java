/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Department;
import com.vtl.repository.DepartmentRepository;
import com.vtl.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentRepository dr;
    
    @Override
    public List<Department> getDepartment() {
        return this.dr.getDepartment();
    }
    
}
