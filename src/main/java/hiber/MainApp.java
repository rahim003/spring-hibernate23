package hiber;

import hiber.config.AppConfig;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

      CarService carService=context.getBean(CarService.class);
      carService.getByName("BMW");
      carService.getUsersBySerial(570);

//      Car car1=new Car("BMW",2003);
//      Car car2=new Car("BMW",570);
//      Car car3=new Car("Mercedec-Benz",180);
//      User user=new User("Nurlan","Atayarov","nurlan@gmail.com");
//      User user1=new User("Kutubek","Gaparov","kutubek@gmail.com");
//      User user2=new User("Kairat","Shabotoev","Kairat@gmail.com");
//      user.setCar(car1);
//      user1.setCar(car2);
//      user2.setCar(car3);
//      userService.add(user);
//      userService.add(user1);
//      userService.add(user2);
//
//      List<User>users=userService.listUsers();
//      for (User user5:users) {
//         System.out.println("Id = "+user5.getId());
//         System.out.println("First Name = "+user5.getFirstName());
//         System.out.println("Last Name = "+user5.getLastName());
//         System.out.println("Email = "+user5.getEmail());
//         System.out.println("Cars = "+user5.getCar());
//         System.out.println();
//      }
      context.close();
   }
}
