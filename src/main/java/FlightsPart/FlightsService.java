package FlightsPart;

import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightsService extends FlightsDao {
    private final FlightsDao dao;
    public FlightsService(LinkedList<Flight> data) {
        super(data);
        dao = new FlightsDao(data);
    }

    public LinkedList<Flight> getAll(Predicate<Flight> p) {
        return (LinkedList<Flight>) getAll().stream()
                .filter(p)
                .collect(Collectors.toList());
    }
    public void modify(Flight f) {
        getAll().stream()
                .filter(e -> e.id.equals(f.id))
                .findFirst()
                .ifPresent(e -> { remove(e); add(f); });
    }
    public void book(String flightId, Booking b) {
        dao.get(flightId).ifPresent(f -> f.bookedPlaces.add(b));
    }
    public void unbook(String flightId, Booking b){
        dao.get(flightId).ifPresent(f -> f.bookedPlaces.remove(b));
    }
}
