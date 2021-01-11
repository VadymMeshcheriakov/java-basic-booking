package Controller;

import Booking.Flight;
import Service.FlightService;

import java.io.IOException;
import java.util.List;

public class FlightController {
    private FlightService flightService;
    public FlightController(FlightService flightService){ this.flightService = flightService;}
    public Flight getFlightByIndex(int index){return this.flightService.getFlightByIndex(index);}
    public Flight getFlightById(long id){return this.flightService.getFlightById(id);}
    public List<Flight> getAllFlights(){return this.flightService.getAllFlights();}
    public Flight getFlightInfo(String departureDateTime, String destination, int numberOfSeats){return this.flightService.getFlightInfo(departureDateTime, destination, numberOfSeats);}
    public void displayAllFlights() { this.flightService.displayAllFlights();}
    public void saveFlight(Flight flight){this.flightService.saveFlight(flight);}
    public void loadDataToDB(List<Flight> flightList) throws IOException{this.flightService.loadDataToDB(flightList);}
    public void loadDataFromDB() throws IOException{this.flightService.loadDataFromDB();}
}
