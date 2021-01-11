package Dao;

import Booking.Flight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionFlightDAO implements FlightDAO{
    private List<Flight> flightList = new ArrayList<>();
    private long idCounter = 1;
    @Override
    public Flight getFlightByIndex(int index){
        if(index < 0 || index > this.flightList.size() - 1){
            return null;
        } else return this.getFlightByIndex(index);
    }
    @Override
    public Flight getFlightById(long id){
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
    @Override
    public void loadDataToDB(List<Flight> flightList) throws IOException {
        DataBase.writeFlight(flightList);
    }
    @Override
    public void loadDataFromDB() throws IOException {
        this.flightList = DataBase.readFlight();

    }
}