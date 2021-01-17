package Controller;

import Booking.Passenger;
import Booking.Person;
import Service.PassengerService;

import java.io.IOException;
import java.util.List;

public class PassengerController {
    private PassengerService passengerService;
    public PassengerController(PassengerService passengerService){this.passengerService = passengerService;}

    public Passenger getPassengerByIndex(int index){return this.passengerService.getPassengerByIndex(index);}
    public Passenger getPassengerById(long id){return this.passengerService.getPassengerById(id);}
    public List<Passenger> getAllPassengers(){return this.passengerService.getAllPassengers();}
    public boolean deletePassengerById(long id){return this.passengerService.deletePassengerById(id);}
    public Passenger createNewPassenger(String name, String surname){return this.passengerService.createNewPassenger(name, surname);}
    public void savePassenger(Passenger passenger){this.passengerService.savePassenger(passenger);}
    public void loadDataToDB(List<Passenger> passengerList) throws IOException{this.passengerService.loadDataToDB(passengerList);}
    public void loadDataFromDB() throws IOException {this.passengerService.loadDataFromDB();}
}
