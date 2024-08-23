/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.service;

import java.util.List;

/**
 *
 * @author Thuy Linh
 */
public interface StatsService {
    public Long countUser();
     public List<Object[]> countPostByUserId();
     public List<Object[]> statsRevenuePostByYear(int year);
     public List<Object[]> statsRevenuePostByMonth(int month) ;
     public List<Object[]> statsCreatedDateByPeriod(int year, String period);
}
