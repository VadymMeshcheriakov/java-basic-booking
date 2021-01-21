package airportcontext;

import controller.FlightController;
import dao.*;
import entity.Flight;
import service.FlightService;

import java.util.List;

public class AirportContext {
    public static FlightController flightController;
    public static UserController userController;
    public static BookingController bookingController;

    public static User currentUser;

    public static void init() {

        List<Flight> flights = Database.readFlight();
        IAirportDao<Flight> flightDao = new FlightDao(flights);
        FlightService flightService = new FlightService(flightDao);
        flightController = new FlightController(flightService);

        List<User> users = Database.readUser();
        IAirportDao<User> userDao = new UserDao(users);
        UserService userService = new UserService(userDao);
        userController = new UserController(userService);

        List<Booking> bookings = Database.readBooking();
        IAirportDao<Booking> bookingDao = new BookingDao(bookings);
        BookingService bookingService = new BookingService(bookingDao);
        bookingController = new BookingController(bookingService);
    }
}
