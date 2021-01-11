package Controller;

import Booking.Booking;
import Service.BookingService;

import java.io.IOException;
import java.util.List;

public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public Booking getBookingByIndex(int index){return this.bookingService.getBookingByIndex(index);}
    public Booking getBookingById(long id){return this.bookingService.getBookingById(id);}
    public List<Booking> getAllBookings(){return this.bookingService.getAllBookings();}
    public boolean deleteBookingById(long id){return this.bookingService.deleteBookingById(id);}
    public void saveBooking(Booking booking){this.bookingService.saveBooking(booking);}
    public void loadDataToDB(List<Booking> bookingList) throws IOException {this.bookingService.loadDataToDB(bookingList);}
    public void loadDataFromDB() throws IOException{this.bookingService.loadDataFromDB();}
}
