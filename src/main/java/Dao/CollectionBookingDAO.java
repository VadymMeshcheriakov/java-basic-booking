package Dao;

import Booking.Booking;
import Booking.Flight;
import Booking.Passenger;
import Controller.PassengerController;
import Logger.BookingLogger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionBookingDAO implements BookingDAO{
    private List<Booking> bookingList = new ArrayList<>();
    private long idCounter = 1;


    @Override
    public Booking getBookingByIndex(int index) {
        if(index < 0 || index > this.bookingList.size() - 1){
            BookingLogger.info("getting booking by index: no booking with such index");
            return null;
        }else {
            BookingLogger.info("getting booking by index");
            return this.bookingList.get(index);
        }
    }
    @Override
    public Booking getBookingById(long bookingId) {
        Booking result = null;
        for (Booking b : this.bookingList) {
            if (b.getBookingId() == bookingId) result = b;
        }
        BookingLogger.info("getting booking by id");
        return result;
    }
    @Override
    public List<Booking> getAllBookings() {
        BookingLogger.info("getting list of bookings");
        return this.bookingList;
    }
    @Override
    public boolean deleteBookingById(long id){
        for(Booking b : this.bookingList){
            bookingList.remove(b);
            return true;
        }
        return false;
    }
    @Override
    public void createBooking(Flight id, Passenger passenger){
        Booking booking = new Booking(id, passenger);
        this.saveBooking(booking);

    }
    @Override
    public void saveBooking(Booking booking){
        int index = this.bookingList.indexOf(booking);

        if(index > -1){
            this.bookingList.set(index, booking);
        } else {
            BookingLogger.info("adding new booking");
            booking.setBookingId(idCounter++);
            this.bookingList.add(booking);
        }
    }
    @Override
    public void loadDataToDB(List<Booking> bookingList) throws IOException {
        BookingLogger.info("loading bookingList from DB");
        DataBase.writeBooking(bookingList);
    }
    @Override
    public void loadDataFromDB() throws IOException {
        BookingLogger.info("saving bookingList to DB");
        this.bookingList = DataBase.readBooking();
    }

}
