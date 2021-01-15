package Dao;


import Booking.Flight;

import java.io.IOException;
import java.util.List;

public interface FlightDAO {
    Flight getFlightByIndex(int index);
    Flight getFlightById(int id);
    List<Flight> getAllFlights();
    void createFlight(int id,  String departureDate, String departureTime, String destination, int numberOfSeats);
    void saveFlight(Flight flightList);
    void loadDataToDB(List<Flight> flightLists) throws IOException;
    void loadDataFromDB() throws IOException;
}
