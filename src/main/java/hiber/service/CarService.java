package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    void add(Car car);
    List<Car> listCars();
    List<?>getByName(String model);
    List<?>getUsersBySerial(int serial);

}
