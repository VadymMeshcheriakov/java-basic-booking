import Controller.BookingController;
import Controller.FlightController;
import Dao.BookingDAO;
import Dao.CollectionBookingDAO;
import Dao.CollectionFlightDAO;
import Dao.FlightDAO;
import Service.BookingService;
import Service.FlightService;

public class FlightContext {
    public static FlightController flightController;
    public static BookingController bookingController;
    public static void init(){
        FlightDAO flightDAO = new CollectionFlightDAO();
        FlightService flightService = new FlightService(flightDAO);
        flightController = new FlightController(flightService);
        BookingDAO bookingDAO = new CollectionBookingDAO();
        BookingService bookingService = new BookingService(bookingDAO);
        bookingController = new BookingController(bookingService);
    }
}
