package FlightsPart;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Flight {
    public String from;
    public String to;
    public int places;
    public LocalDateTime time;
    public String id;
    public LinkedList<Booking> bookedPlaces;

    public Flight(String from, String to, int places, LocalDateTime time, LinkedList<Booking> bookedPlaces, String id) {
        this.from = from;
        this.to = to;
        this.places = places;
        this.time = time;
        this.id = id;
    }

    public Flight(String to, int places, LocalDateTime time, LinkedList<Booking> bookedPlaces, String id) {
        this.from = "Kiyv";
        this.to = to;
        this.places = places;
        this.time = time;
        this.id = id;
    }
    @Override
    public String toString() {
        return String.format("%s - %s (%d/%d) %s | %s", from, to, bookedPlaces.size(), places, time.toString(), id);
    }
}
