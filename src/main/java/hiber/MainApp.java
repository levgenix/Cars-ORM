package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Vasya", "Vasechkin", "vasechkin@mail.io"));
      userService.add(new User("Petya", "Sidorov", "sidorov@mail.io"));
      userService.add(new User("Olga", "Petrova", "petrova@mail.io"));
      userService.add(new User("Svetlana", "Ivanova", "ivanova@mail.io"));

      for (User user : userService.listUsers()) {
         System.out.println(user);
      }

      context.close();
   }
}
