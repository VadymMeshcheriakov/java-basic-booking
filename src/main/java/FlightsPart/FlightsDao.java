package FlightsPart;

import java.util.LinkedList;
import java.util.Optional;

public class FlightsDao {
    private final LinkedList<Flight> data;

    public FlightsDao(LinkedList<Flight> data) {
        this.data = data;
    }

    public void add(Flight f) {data.add(f);}
    public void remove(Flight f) {data.remove(f);}
    public Optional<Flight> get(String id) {
        return data.stream().filter(e -> e.id.equals(id)).findFirst();
    }
    public LinkedList<Flight> getAll() { return data; }
}
