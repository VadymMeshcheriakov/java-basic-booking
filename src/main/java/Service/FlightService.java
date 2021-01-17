package Service;


import Booking.Flight;
import Dao.FlightDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FlightService {
   final private FlightDAO flightDAO;
    public FlightService(FlightDAO flightDAO){this.flightDAO = flightDAO;}
    public Flight getFlightByIndex(int index){
        return this.flightDAO.getFlightByIndex(index);
    }
    public List<Flight> getFlightById(int id){
        return this.flightDAO.getAllFlights().stream()
                .filter(flight -> flight.getFlightId() == id)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
    public List<Flight> getAllFlights(){return this.flightDAO.getAllFlights();}
    public void displayAllFlights() {this.flightDAO.getAllFlights().forEach(System.out::println);}
    public List<Flight> getFlightInfo(String destination, String departureDate, int numberOfSeats){
          return this.flightDAO.getAllFlights()
                  .stream()
                  .filter(Objects::nonNull)
                  .filter(flight -> flight.getDestination().matches(destination)  &&
                          flight.getDepartureDate().equals(departureDate) &&
                          flight.getNumberOfSeats() > numberOfSeats)
                  .peek(System.out::println)
                 .collect(Collectors.toList());
    }
    public void createFlight(int id, String departureDate, String departureTime, String destination, int numberOfSeats){
        Flight flight = new Flight(id, departureDate,departureTime, destination, numberOfSeats);
        this.flightDAO.saveFlight(flight);
    }
    public void saveFlight(Flight flight){this.flightDAO.saveFlight(flight);}
    public void loadDataToDB(List<Flight> flightList) throws IOException{this.flightDAO.loadDataToDB(flightList);}
    public void loadDataFromDB() throws IOException{this.flightDAO.loadDataFromDB();}
}
