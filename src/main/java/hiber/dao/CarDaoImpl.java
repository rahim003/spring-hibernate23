package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;
@Component
public class CarDaoImpl  implements CarDao{


    private final SessionFactory sessionFactory;
@Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.openSession().save(car);
    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.openSession().createQuery("from Car ");
        return query.getResultList();
    }
    @Override
    public Car getName(String name) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<Car>cars=session.createQuery("from Car").list();
        cars.stream().filter(car -> car.getModel().equals(name)).forEach(System.out::println);
        session.getTransaction().commit();
        return (Car) cars;
    }

    @Override
    public List<?> getByName(String model) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<User>list=session.createQuery("from User").list();
        list.stream().filter(user -> user.getCar().getModel().equals(model)).forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<?> getUsersBySerial(int serial) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<User>list=session.createQuery("from User").list();
        list.stream().filter(user -> user.getCar().getSeries()==serial).forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
        return list;
    }


}
