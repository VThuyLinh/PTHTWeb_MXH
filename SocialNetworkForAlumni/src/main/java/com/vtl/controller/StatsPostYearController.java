/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Thuy Linh
 */
@Controller
public class StatsPostYearController {
    @Autowired
    private StatsService ss;
    
    @GetMapping("/StatsYear")
    public String stats(Model model) {
        model.addAttribute("revenues", ss.statsRevenuePostByYear(2024) );
        
        return "statsYear";
    }
}
