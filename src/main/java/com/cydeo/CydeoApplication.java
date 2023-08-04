package com.cydeo;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.services.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CydeoApplication {

	public static void main(String[] args) {

		Comment myComment = new Comment();
		myComment.setAuthor("ziya");
		myComment.setText("good job ziya, continue Spring Framework");

		ApplicationContext context = SpringApplication.run(CydeoApplication.class, args);

		CommentService commentService = context.getBean(CommentService.class);
		commentService.publishComment(myComment);
		commentService.printAppConfigData(context.getBean(AppConfigData.class));
		commentService.printDBConfigData(context.getBean(DBConfigData.class));
	}

}
