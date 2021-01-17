import Controller.BookingController;
import Controller.FlightController;
import Controller.PassengerController;
import Dao.*;
import Service.BookingService;
import Service.FlightService;
import Service.PassengerService;

public class FlightContext {
    public static FlightController flightController;
    public static BookingController bookingController;
    public static PassengerController passengerController;
    public static void init(){
        FlightDAO flightDAO = new CollectionFlightDAO();
        FlightService flightService = new FlightService(flightDAO);
        flightController = new FlightController(flightService);
        BookingDAO bookingDAO = new CollectionBookingDAO();
        BookingService bookingService = new BookingService(bookingDAO);
        bookingController = new BookingController(bookingService);
        PassengerDAO passengerDAO = new CollectionPassengerDAO();
        PassengerService passengerService = new PassengerService(passengerDAO);
        passengerController = new PassengerController(passengerService);
    }
}
