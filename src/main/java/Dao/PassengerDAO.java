package Dao;

import Booking.Passenger;
import Booking.Person;

import java.io.IOException;
import java.util.List;

public interface PassengerDAO {
    Passenger getPassengerByIndex(int index);
    Passenger getPassengerById(long id);
    List<Passenger> getAllPassengers();
    boolean deletePassengerById(long id);
    void savePassenger(Passenger passenger);
    void loadDataToDB(List<Passenger> passengerList) throws IOException;
    void loadDataFromDB() throws IOException;
}
