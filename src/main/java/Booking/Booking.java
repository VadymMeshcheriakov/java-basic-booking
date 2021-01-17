package Booking;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Serializable {
    protected long bookingId;
    private final LocalDateTime dateTime = LocalDateTime.now();
    private Passenger passenger;
    private List<Flight> flights;
    private Flight id;
    final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm";

    public Booking(Flight id){
        this.id = id;
    }
    public Booking(Flight id, Passenger passenger) {
        this.id = id;
        this.passenger = passenger;
    }


    public long getBookingId(){return bookingId;}
    public  void setBookingId(long bookingId){this.bookingId = bookingId;}
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public Passenger getPassenger(){return this.passenger;}
    public void setPassenger(Passenger passengers){this.passenger = passenger;}
    public List<Flight> getFlights() {return this.flights;}
    public void setFlight(List<Flight> flights) {this.flights = flights;}
//    public boolean addPassenger(Passenger passenger) {
//        if (!passenger.contains(passenger) &&
//                passenger != null) {
//            passenger.add(passenger);
//            return true;
//        } else
//            return false;
//    }
//    public boolean deletePassenger(Person passenger) {
//        if (!passengers.contains(passenger)) return false;
//
//        passengers.remove(passenger);
//        return true;
//    }
//
//    public boolean deletePassenger(int index) {
//        if (index >= 0 && index < passengers.size()) {
//            if (!passengers.contains(passengers.get(index))) return false;
//
//            passengers.remove(passengers.get(index));
//            return true;
//        }
//        return false;
//    }
    public Passenger createNewPassenger(String name, String surname) {
        return new Passenger(name, surname);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id;
    }
    @Override
    public String toString(){
        return "Booking{" + "id= " + id + ", dateTime= " + dateTime.format(DateTimeFormatter
                .ofPattern(DATE_TIME_FORMAT)) + ", flight = " + flights +
                ", passengers= " + passenger + "}";
    }

}
