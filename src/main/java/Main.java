import Booking.Flight;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

//        Flight flight = new Flight(1, "2021-01-10 01:10", "Rome", 120);
//        System.out.println(flight);
            FlightContext.init();
            Console.start();
    }
}