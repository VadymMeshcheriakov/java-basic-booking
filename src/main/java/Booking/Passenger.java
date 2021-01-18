package Booking;

import java.io.Serializable;

public class Passenger extends Person implements Serializable {
    protected long id;

    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    public Passenger(String name, String surname) {
        super(name, surname);
    }
    @Override
    public String toString(){
        return "Booking.Passenger{"
                + "pass_ID= " + this.getId() + //? or id
                 ", name= " + this.getName() +
                ", surname= " + this.getSurname() + "}";
    }
}
