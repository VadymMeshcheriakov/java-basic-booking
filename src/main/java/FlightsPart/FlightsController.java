package FlightsPart;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class FlightsController extends FlightsDao {
    private final FlightsService service;
    public FlightsController(LinkedList<Flight> data) {
        super(data);
        service = new FlightsService(data);
    }

    public static LinkedList<Flight> read(String fileWay) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileWay)));
        LinkedList<Flight> result = new LinkedList<>();
        reader.lines().forEach(l -> {
            String[] args = l.split(" ");
            LinkedList<Booking> bookingList = new LinkedList<>();
            //считать список бронировок
            Flight f = new Flight(args[0], args[1], Integer.getInteger(args[2]), LocalDateTime.of(Integer.getInteger(args[3]), Integer.getInteger(args[4]), Integer.getInteger(args[5]), Integer.getInteger(args[6]), Integer.getInteger(args[7])), bookingList, args[8]);
            result.add(f);
        });
        return result;
    }
    public static void write(String fileWay, Flight f, BufferedWriter writer) {
        writer.write(String.format("%s %s %d %d %d %d %d %d %s %s", f.from, f.to, f.places,
                f.time.getYear(), f.time.getMonthValue(), f.time.getDayOfMonth(), f.time.getHour(), f.time.getMinute(),
                f.id, f.bookedPlaces.stream().map(b -> b.toString()).reduce((a, b) -> a + " " + b)
        ));
    }


}
