
package com.vtl.socialnetwork;


import com.vtl.repository.impl.ImageRepositoryImpl;
import com.vtl.repository.impl.NotificationRepositoryImpl;
import com.vtl.repository.impl.UserRepositoryImpl;
//import com.vtl.repository.impl.PostRepositoryImpl;
//import com.vtl.repository.impl.StatsRepositoryImpl;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.Map;

/**
 *
 * @author Thuy Linh
 */
public class SocialNetwork {

    public static void main(String[] args) {

        UserRepositoryImpl us= new UserRepositoryImpl();
        us.getAllUser().forEach(a-> System.out.println(a.getUsername()));
        us.getAllUser().forEach(a-> System.out.println(a.getId()));
        
//        ImageRepositoryImpl i = new ImageRepositoryImpl();
////        i.getImageByPostId(1);
//        i.getImage(1).forEach(a-> System.out.println(a.getPath()));
        
//        Map<String, String> params = new HashMap<>();
//        params.put("q", "Nên");
//        PostRepositoryImpl p= new PostRepositoryImpl();
//        p.getPost(params).forEach(c->System.out.println(c.getContent()));
//          CommentRepositoryImpl c= new CommentRepositoryImpl();
//          c.getComment().forEach(a-> System.out.println(a.getContent()));
//          StatsRepositoryImpl s = new StatsRepositoryImpl();
//        s.statsRevenuePostByMonth(9).forEach(o -> System.out.printf("%s: %s: %s (%s)\n", o[0], o[1],o[2],o[3]));
//        System.out.println(s.countUser().toString());
//          s.countPostByUserId().forEach(o -> System.out.printf("%s: %s\n", o[0], o[1]));
    }
}
