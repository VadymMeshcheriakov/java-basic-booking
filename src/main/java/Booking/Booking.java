package Booking;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Serializable {
//    private final long number;
    protected long id;
    private final LocalDateTime dateTime = LocalDateTime.now();
    private List<Person> passengers = new ArrayList();
    private List<Flight> flights = new ArrayList<>();
    final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm";

    public Booking(List<Flight> flights){
//        this.number = setBookingNumber();
        this.flights = flights;
    }
    public Booking(List<Flight> flights, List<Person> passengers) {
//        this.number = setBookingNumber();
        this.flights = flights;
        this.setPassengers(passengers);
    }
//    public long getBookingNumber() {
//        return this.number;
//    }
//    private long setBookingNumber() {
//
//        return dateTime.getYear() * 10000000000L +
//                dateTime.getMonth().getValue() * 100000000 +
//                dateTime.getDayOfMonth() * 1000000 +
//                dateTime.getHour() * 10000 +
//                dateTime.getMinute() * 100 +
//                dateTime.getSecond();
//
//    }
    public long getId(){return id;}
    public  void setId(long id){this.id = id;}
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public List<Person> getPassengers(){return this.passengers;}
    public void setPassengers(List<Person> passengers){this.passengers = passengers;}
    public List<Flight> getFlights() {return this.flights;}
    public void setFlight(List<Flight> flights) {this.flights = flights;}
    public boolean addPassenger(Person passenger) {
        if (!passengers.contains(passenger) &&
                passenger != null) {
            passengers.add(passenger);
            return true;
        } else
            return false;
    }
    public boolean deletePassenger(Person passenger) {
        if (!passengers.contains(passenger)) return false;

        passengers.remove(passenger);
        return true;
    }

    public boolean deletePassenger(int index) {
        if (index >= 0 && index < passengers.size()) {
            if (!passengers.contains(passengers.get(index))) return false;

            passengers.remove(passengers.get(index));
            return true;
        }
        return false;
    }
    public Passenger createNewPassenger(String name, String surname) {
        return new Passenger(name, surname);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id;
//        return number == booking.number;
    }
    @Override
    public String toString(){
        return "Booking{" + "id= " + id + ", dateTime= " + dateTime.format(DateTimeFormatter
                .ofPattern(DATE_TIME_FORMAT)) + ", flight = " + flights +
                ", passengers= " + passengers + "}";
    }

}
