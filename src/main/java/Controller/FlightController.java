package Controller;


import Booking.Flight;
import Service.FlightService;

import java.io.IOException;
import java.util.List;

public class FlightController {
    private FlightService flightService;
    public FlightController(FlightService flightService){ this.flightService = flightService;}
    public Flight getFlightByIndex(int index){return this.flightService.getFlightByIndex(index);}
    public List<Flight> getFlightById(int id){return this.flightService.getFlightById(id);}
    public List<Flight> getAllFlights(){return this.flightService.getAllFlights();}
    public List<Flight> getFlightInfo(String departureDate, String destination, int numberOfSeats){return this.flightService.getFlightInfo(departureDate, destination, numberOfSeats);}
    public void createFlight(String departureDate, String departureTime, String destination, int numberOfSeats){ this.flightService.createFlight( departureDate, departureTime, destination, numberOfSeats);}
    public void displayAllFlights() { this.flightService.displayAllFlights();}
    public void saveFlight(Flight flight){this.flightService.saveFlight(flight);}
    public void loadDataToDB(List<Flight> flightList) throws IOException{this.flightService.loadDataToDB(flightList);}
    public void loadDataFromDB() throws IOException{this.flightService.loadDataFromDB();}
}
