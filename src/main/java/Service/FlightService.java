package Service;


import Booking.Flight;
import Dao.FlightDAO;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FlightService {
    private FlightDAO flightDAO;
    public FlightService(FlightDAO flightDAO){this.flightDAO = flightDAO;}
    public Flight  getFlightByIndex(int index){return this.flightDAO.getFlightByIndex(index);}
    public Flight getFlightById(long id){return this.flightDAO.getFlightById(id);}
    public List<Flight> getAllFlights(){return this.flightDAO.getAllFlights();}
    public void displayAllFlights() {this.flightDAO.getAllFlights().forEach(System.out::println);}
    public List<Flight> getFlightInfo(String destination, String departureDateTime, int numberOfSeats){
          return this.flightDAO.getAllFlights()
                  .stream()
                  .filter(Objects::nonNull)
                  .filter(flight -> flight.getDestination().equals(destination)  &&
                          flight.getDepartureDateTime().equals(departureDateTime) &&
                          flight.getNumberOfSeats() > numberOfSeats)
                 .collect(Collectors.toList());
    }
    public void createFlight(int id, String departureDateTime, String destination, int numberOfSeats){
        Flight flight = new Flight(id, departureDateTime, destination, numberOfSeats);
        this.flightDAO.saveFlight(flight);
    }
    public void saveFlight(Flight flight){this.flightDAO.saveFlight(flight);}
    public void loadDataToDB(List<Flight> flightList) throws IOException{this.flightDAO.loadDataToDB(flightList);}
    public void loadDataFromDB() throws IOException{this.flightDAO.loadDataFromDB();}
}
