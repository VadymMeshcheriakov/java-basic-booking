package Booking;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Flight implements Serializable {
    protected long id;
    private String departureDateTime;
    private String destination;
    private int numberOfSeats;
    private List<Person> passengers;


    public Flight(long id, String departureDateTime, String destination, int numberOfSeats){
        this.id = id;
        this.departureDateTime = departureDateTime;
        this.destination = destination;
        this.numberOfSeats = numberOfSeats;
        this.passengers = new ArrayList<>();
    }
    public long getFlightId(){return id;}
    public void setFlightId(long id){this.id = id;}
    public String getDepartureDateTime(){return departureDateTime;}
    public void setDepartureDateTime(String departureDateTime){this.departureDateTime = departureDateTime;}
    public LocalDateTime getDateTime(String departureDateTime) {
        return LocalDateTime.parse(departureDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm") );    }
    public String getDestination(){return destination;}
    public void setDestination(String destination){this.destination = destination;}
    public int getNumberOfSeats(){return numberOfSeats;}
    public void setNumberOfSeats(int numberOfSeats){this.numberOfSeats = numberOfSeats;}
    public int getPassengersOnBoard(){return passengers.size();}
    public List<Person> getPassengers(){return passengers;}
    public void setPassengers(List<Person> passengers){this.passengers = passengers;}
    public boolean addPassenger(Person passenger){
        if(!passengers.contains(passenger) && passengers.size() < numberOfSeats
        && passenger != null){
            passengers.add(passenger);
           return true;
        } else {
            return false;
        }
    }
    public boolean deletePassenger(Person passenger){
        if(!passengers.contains(passenger)) return false;
        passengers.remove(passenger);
        return true;
    }
    public boolean deletePassenger(int index){
        if(index <= 0 && index < passengers.size()){
            if(!passengers.contains(passengers.get(index))) return false;
            passengers.remove(passengers.get(index));
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == (flight.getFlightId());
    }

    @Override
    public String toString(){
        return "Flight{id= " + id  + ", departureDateTime= " + getDateTime(departureDateTime) + ", destination= " +
                destination  + ", numberOfSeats= " + numberOfSeats + "}";
    }
}
