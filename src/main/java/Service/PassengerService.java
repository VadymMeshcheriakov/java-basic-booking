package Service;

import Booking.Passenger;
import Dao.PassengerDAO;

import java.io.IOException;
import java.util.List;

public class PassengerService {
    private PassengerDAO passengerDAO;

    public PassengerService(PassengerDAO passengerDAO){this.passengerDAO = passengerDAO;}

    public Passenger getPassengerByIndex(int index){return this.passengerDAO.getPassengerByIndex(index);}
    public Passenger getPassengerById(long id){ return this.passengerDAO.getPassengerById(id);}
    public List<Passenger> getAllPassengers(){return this.passengerDAO.getAllPassengers();}
    public boolean  deletePassengerById(long id){return this.passengerDAO.deletePassengerById(id);}
    public void savePassenger(Passenger passenger){this.passengerDAO.savePassenger(passenger);}
    public void loadDataToDB(List<Passenger> passengerList) throws IOException{this.passengerDAO.loadDataToDB(passengerList);}
    public void loadDataFromDB() throws IOException{this.passengerDAO.loadDataFromDB();}
}
