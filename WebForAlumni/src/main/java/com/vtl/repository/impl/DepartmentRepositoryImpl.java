/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Department;
import com.vtl.repository.DepartmentRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Thuy Linh
 */



@Repository
@Transactional
public class DepartmentRepositoryImpl implements DepartmentRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Department> getDepartment()
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("Department.findAll");
           
             return q.getResultList();
        
    }
}
