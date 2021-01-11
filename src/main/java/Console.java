
import java.io.IOException;
import java.util.Scanner;

public class Console {
    public static void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run){
            printMenuItems();
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    FlightContext.flightController.loadDataFromDB();
                    break;
                case "2":
                    FlightContext.flightController.displayAllFlights();
                case "3":
                    System.out.println("Please enter flight ID: ");
                    long flightId = readNumber(scanner);
                    FlightContext.flightController.getFlightById(flightId);
                    break;
                case "4":
                    boolean subRun = true;
                    while (subRun){
                        printSubMenuItems();
                        String submenuItem = scanner.nextLine();
                        switch (submenuItem){
                            case "1":
                                System.out.println("Please, enter your destination: ");
                                String destination = scanner.nextLine();
                                System.out.println("Please, enter your date: ");
                                String flightDate = scanner.nextLine();
                                System.out.println("Please, enter number of tickets: ");
                                int numTickets = readNumber(scanner);
                                FlightContext.flightController.getFlightInfo(destination, flightDate, numTickets);
                                break; //??
                            case "2":
                                System.out.println("Please, choose your flight number to book:");
                                int flightIndex = readNumber(scanner);
                                FlightContext.flightController.getFlightByIndex(flightIndex);
                                System.out.println("Please, enter your name: ");
                                String name = scanner.nextLine();
                                System.out.println("Please, enter your surname: ");
                                String surname = scanner.nextLine();
//                                FlightContext.bookingController.createBooking();
                                break;
                            case "0":
                                subRun = false;
                            default:
                                System.out.println("Unknown command");
                                break;

                        }
                    }
                break;
                case "5":
                    System.out.println("Please, enter your booking ID: ");
                    long bookingId = readNumber(scanner);
                    FlightContext.bookingController.deleteBookingById(bookingId);
                    break;
                case "6":
                    System.out.println("Please, enter your name: ");
                    String name = scanner.nextLine();
                    System.out.println("Please, enter your surname: ");
                    String surname = scanner.nextLine();
                    FlightContext.bookingController.getAllBookings();//?????
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
    public static void printMenuItems(){
        System.out.println("Please enter command");
        System.out.println("1. Load all flights from Kiev");
        System.out.println("2. Display all flights from Kiev");
        System.out.println("3. Display all flight info");
        System.out.println("4. Book your flight");
        System.out.println("5. Delete your booking");
        System.out.println("6. Display all my bookings");
    }
    private static void printSubMenuItems(){
        System.out.println("Please enter command");
        System.out.println("1. Display your flight");
        System.out.println("2. Book your flight");
        System.out.println("0. Back to main menu");
    }
    private static int readNumber(Scanner scanner) {
        int result = 0;
        while (result == 0){
            System.out.println("Enter number:");
            String number = scanner.nextLine();
            try {
                result = Integer.parseInt(number);
            } catch (Exception e) {
                System.out.println("This is not a number.");
            }
        }
        return result;
    }
}