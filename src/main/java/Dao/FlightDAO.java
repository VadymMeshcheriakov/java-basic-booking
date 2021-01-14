package Dao;


import Booking.Flight;

import java.io.IOException;
import java.util.List;

public interface FlightDAO {
    Flight getFlightByIndex(int index);
    Flight getFlightById(long id);
    List<Flight> getAllFlights();
//    boolean deleteFlightById(long id);
    void createFlight(int id,  String departureDateTime, String destination, int numberOfSeats);
    void saveFlight(Flight flightList);
    void loadDataToDB(List<Flight> flightLists) throws IOException;
    void loadDataFromDB() throws IOException;
}
