package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component

public class CarServiceImpl implements CarService {
    private CarDao carDao;
    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Override
    public List<?> getByName(String model) {
        return carDao.getByName(model);
    }

    @Override
    public List<?> getUsersBySerial(int serial) {
        return carDao.getUsersBySerial(serial);
    }


}
