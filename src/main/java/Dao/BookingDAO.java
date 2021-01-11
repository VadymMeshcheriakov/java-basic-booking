package Dao;

import Booking.Booking;

import java.io.IOException;
import java.util.List;

public interface BookingDAO {
    Booking getBookingByIndex(int index);
    Booking getBookingById(long id);
    List<Booking> getAllBookings();
    boolean deleteBookingById(long id);
    void saveBooking(Booking booking);
    void loadDataToDB(List<Booking> bookings) throws IOException;
    void loadDataFromDB() throws IOException;
}