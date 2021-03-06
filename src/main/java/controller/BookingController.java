package controller;

import entity.Booking;
import entity.Flight;
import logger.AirportLogger;
import service.BookingService;

import java.util.List;

public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        AirportLogger.info("создание обьекта BookingController");
        this.bookingService = bookingService;
    }

    public List<Booking> getAllBookings() {
        AirportLogger.info("получение списка всех бронирований");
        return this.bookingService.getAllBookings(); }
    public boolean deleteBookingById(Long id) {
        AirportLogger.info("удаление бронирования по ID");
        return this.bookingService.deleteBookingById(id); }
    public void saveBooking(Booking booking) {
        AirportLogger.info("сохранение бронирования");
        this.bookingService.saveBooking(booking);
    }
    public List<Booking> getBookingsByUserId (Long id){
        AirportLogger.info("получение бронирований по ID пользователя");
        return this.bookingService.getBookingsByUserId(id); }
    public int getCountBookingByFlightId(long id) {
        AirportLogger.info("получение суммы всех бронирований по ID рейса");
        return this.bookingService.getCountBookingByFlightId(id); }
    public List<Flight> getFlightsEmptySeats(List<Flight> flights, int userCount){
        AirportLogger.info("получение списка всех рейсов со свободными местами");
        return this.bookingService.getFlightsEmptySeats(flights, userCount); }
}
