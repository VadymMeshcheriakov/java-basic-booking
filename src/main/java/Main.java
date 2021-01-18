import Booking.Booking;
import Booking.Flight;
import Booking.Passenger;
import Booking.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
//        Flight f = new Flight(10, "21/01/2021", "12:00", "London", 10);
//        Passenger p = new Passenger("Tim", "Roth");
//        Passenger p1 = new Passenger("Nim", "Dre");
//
//         Booking b = new Booking(f, p);
//         Booking b1 = new Booking(f, p1);
//         b.createNewPassenger("Qwet", "Adf");
//
//        System.out.println(b);
//        System.out.println(b1);
            FlightContext.init();
            Console.start();
    }
}