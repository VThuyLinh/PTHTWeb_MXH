/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.vtl.socialnetwork;

import com.vtl.repository.impl.CommentRepositoryImpl;
import com.vtl.repository.impl.PostRepositoryImpl;
import com.vtl.repository.impl.StatsRepositoryImpl;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thuy Linh
 */
public class SocialNetwork {

    public static void main(String[] args) throws ParseException, SQLException {

//        Map<String, String> params = new HashMap<>();
//        params.put("q", "Nên");
//        PostRepositoryImpl p= new PostRepositoryImpl();
//        p.getPost(params).forEach(c->System.out.println(c.getContent()));
//          CommentRepositoryImpl c= new CommentRepositoryImpl();
//          c.getComment().forEach(a-> System.out.println(a.getContent()));
          StatsRepositoryImpl s = new StatsRepositoryImpl();
//        s.statsRevenuePostByMonth(9).forEach(o -> System.out.printf("%s: %s: %s (%s)\n", o[0], o[1],o[2],o[3]));
//        System.out.println(s.countUser().toString());
          s.countPostByUserId().forEach(o -> System.out.printf("%s: %s\n", o[0], o[1]));
    }
}
