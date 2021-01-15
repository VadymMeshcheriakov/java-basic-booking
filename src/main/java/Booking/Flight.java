package Booking;


import javax.swing.text.DateFormatter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Flight implements Serializable {
    protected int id;
    private String departureDate;
    private String departureTime;
    private String destination;
    private int numberOfSeats;
    private List<Person> passengers;


    public Flight(int id, String departureDate, String departureTime, String destination, int numberOfSeats){
        this.id = id;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.numberOfSeats = numberOfSeats;
        this.passengers = new ArrayList<>();
    }
    public int getFlightId(){return id;}
    public void setFlightId(int id){this.id = id;}
    public String getDepartureDate(){return departureDate;}
    public void setDepartureDate(String departureDate){this.departureDate = departureDate;}
    public String getDepartureTime(){return departureTime;}
    public void setDepartureTime(String departureTime){this.departureTime = departureTime;}
    public LocalDate getDate(String departureDate) {
        return LocalDate.parse(departureDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));}
    public LocalTime getTime(String departureTime) {
        return LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm"));}
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
        return "Flight{id= " + id  + ", departureDate= " + getDate(departureDate) +
                 ", departureTime= " + getTime(departureTime) + ", destination= " +
                destination  + ", numberOfSeats= " + numberOfSeats + "}";
    }
}
