package Dao;

import Booking.Passenger;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionPassengerDAO implements PassengerDAO {
    private List<Passenger> passengerList = new ArrayList<>();
    private long idCounter = 1;

    @Override
    public Passenger getPassengerByIndex(int index) {
        if (index < 0 || index > this.passengerList.size() - 1) {
//            PassengerLogger.info("getting booking by index: no booking with such index");
            return null;
        } else {
//            PassengerLogger.info("getting booking by index");
            return this.passengerList.get(index);
        }
    }

    @Override
    public Passenger getPassengerById(long id) {
        Passenger result = null;
        for (Passenger p : this.passengerList) {
            if (p.getId() == id) result = p;
        }
//        PassengerLogger.info("getting booking by id");
        return result;
    }

    @Override
    public List<Passenger> getAllPassengers() {
//        PassengerLogger.info("getting list of bookings");
        return this.passengerList;
    }

    @Override
    public boolean deletePassengerById(long id) {
        for (Passenger p : this.passengerList) {
            passengerList.remove(p);
            return true;
        }
        return false;
    }

    @Override
    public void savePassenger(Passenger passenger) {
        int index = this.passengerList.indexOf(passenger);

        if (index > -1) {
            this.passengerList.set(index, passenger);
        } else {
//            PassengerLogger.info("adding new booking");
            passenger.setId(idCounter++);
            this.passengerList.add(passenger);
        }
    }

    @Override
    public void loadDataToDB(List<Passenger> passengerList) throws IOException {
//        PassengerLogger.info("loading bookingList from DB");
        DataBase.writePassenger(passengerList);
    }

    @Override
    public void loadDataFromDB() throws IOException {
//        PassengerLogger.info("saving bookingList to DB");
        this.passengerList = DataBase.readPassenger();
    }
}