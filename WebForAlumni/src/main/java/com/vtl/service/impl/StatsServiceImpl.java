/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.repository.StatsRepository;
import com.vtl.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class StatsServiceImpl implements StatsService{

    @Autowired
    private StatsRepository ss;
    @Override
    public Long countUser() {
        return ss.countUser();
    }

    @Override
    public List<Object[]> countPostByUserId() {
        return ss.countPostByUserId();
    }

    @Override
    public List<Object[]> statsRevenuePostByYear(int year) {
        return ss.statsRevenuePostByYear(year);
    }

    @Override
    public List<Object[]> statsRevenuePostByMonth(int month) {
       return ss.statsRevenuePostByMonth(month);
    }

    @Override
    public List<Object[]> statsCreatedDateByPeriod(int year, String period) {
        return ss.statsCreatedDateByPeriod(year, period);
    }
    
}
