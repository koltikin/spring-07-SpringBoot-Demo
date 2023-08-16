package com.cydeo.services;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private final AppConfigData appConfigData;
    private final DBConfigData dbConfigData;

    public void publishComment(Comment comment){
        // save in the DB
        commentRepository.storeComment(comment);


        // save in the DB
        commentNotificationProxy.sendComment(comment);

    }

    public void printAppConfigData(){
        System.out.println(appConfigData.getUserName());
        System.out.println(appConfigData.getPassWord());
        System.out.println(appConfigData.getUrl());
    }

    public void printDBConfigData(){
        System.out.println(dbConfigData.getUsername());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());
    }



}
