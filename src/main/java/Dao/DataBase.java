package Dao;

import Booking.Booking;
import Booking.Passenger;
import Booking.Flight;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String path = "D:\\Java-step-Booking\\java-basic-booking\\database.txt";
    public static void writeBooking(List<Booking> bookingList){
    try{
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(bookingList);
    } catch (Exception e){
//        FamilyLogger.error("writing list of bookings into file");
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
    }
    public static List<Booking> readBooking(){
        List<Booking> bookingList = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            bookingList = ((List<Booking>)ois.readObject());
        }catch (Exception e){
//            FamilyLogger.error("reading list of bookings from file");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return bookingList;
    }
    public static void writePassenger(List<Passenger> passengerList){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(passengerList);
        } catch (Exception e){
//        FamilyLogger.error("writing list of bookings into file");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static List<Passenger> readPassenger(){
        List<Passenger> passengerList = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            passengerList = ((List<Passenger>)ois.readObject());
        }catch (Exception e){
//            FamilyLogger.error("reading list of bookings from file");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return passengerList;
    }
    public static void writeFlight(List<Flight> flightList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flightList);
        } catch (Exception e) {
//        FamilyLogger.error("writing list of bookings into file");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

        public static List<Flight> readFlight(){
            List<Flight> flightList = new ArrayList<>();
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
                flightList = ((List<Flight>)ois.readObject());
            }catch (Exception e){
//            FamilyLogger.error("reading list of bookings from file");
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
            return flightList;
        }
}
