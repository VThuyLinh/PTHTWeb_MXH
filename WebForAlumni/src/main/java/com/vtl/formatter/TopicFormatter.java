/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.formatter;

import com.vtl.pojo.Topic;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Thuy Linh
 */
public class TopicFormatter implements Formatter<Topic>{
    @Override
    public String print(Topic t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Topic parse(String topicId, Locale locale) throws ParseException {
        Topic t = new Topic();
        t.setId(Integer.parseInt(topicId));
        
        return t;
    }
}
