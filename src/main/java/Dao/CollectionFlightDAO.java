package Dao;

import Booking.Flight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectionFlightDAO implements FlightDAO{
    private List<Flight> flightList = new ArrayList<>();
    private int idCounter = 1;
    @Override
    public Flight getFlightByIndex(int index){
        if(index < 0 || index > this.flightList.size() - 1){
            return null;
        } else return this.getAllFlights().get(index);
    }
    @Override
    public Flight getFlightById(int id){
        Flight result = null;
        for(Flight f : this.flightList){
            if(f.getFlightId() == id) result = f;
        }
        return result;
    }
    @Override
    public List<Flight> getAllFlights(){
        return this.flightList;
    }
    @Override
    public void saveFlight(Flight flight){
        int index = this.flightList.indexOf(flight);
        if( index > -1){
            this.flightList.set(index, flight);
        } else {
            flight.setFlightId(idCounter++);
            this.flightList.add(flight);
        }
    }
//    @Override
//    public List<Flight> getFlightInfo(String destination, String departureDate, int numberOfSeats){
//        return this.getAllFlights()
//                .stream()
//                .filter(Objects::nonNull)
//                .filter(flight -> flight.getDestination().matches(destination)  &&
//                        flight.getDepartureDate().equals(departureDate) &&
//                        flight.getNumberOfSeats() > numberOfSeats)
//                .peek(System.out::println)
//                .collect(Collectors.toList());
//    }
    @Override
    public void createFlight( String departureDate, String departureTime, String destination, int numberOfSeats){
        Flight flight = new Flight( departureDate, departureTime,destination, numberOfSeats);
        this.saveFlight(flight);
    }
    @Override
    public void loadDataToDB(List<Flight> flightList) throws IOException {
        DataBase.writeFlight(flightList);
    }
    @Override
    public void loadDataFromDB() throws IOException {
        this.flightList = DataBase.readFlight();

    }
}
