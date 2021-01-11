package Service;

import Booking.Booking;
import Dao.BookingDAO;

import java.io.IOException;
import java.util.List;

public class BookingService {
    private  BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO){
        this.bookingDAO = bookingDAO;
    }
    public Booking getBookingByIndex(int index){return this.bookingDAO.getBookingByIndex(index);}
    public Booking getBookingById(long id){return this.bookingDAO.getBookingById(id);}
    public List<Booking> getAllBookings(){return this.bookingDAO.getAllBookings();}
    public boolean deleteBookingById(long id){return this.bookingDAO.deleteBookingById(id);}
    public void saveBooking(Booking booking){this.bookingDAO.saveBooking(booking);}
    public void loadDataToDB(List<Booking> bookingList) throws IOException {this.bookingDAO.loadDataToDB(bookingList);}
    public void loadDataFromDB() throws IOException{this.bookingDAO.loadDataFromDB();}
}