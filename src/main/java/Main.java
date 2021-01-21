import console.ConsoleMenu;
import helpers.DBInit;
import airportcontext.AirportContext;

public class Main {
    public static void main(String[] args) {
        DBInit.initAll();     // --> перезаписать базу данных рейсов и пользователей

        AirportContext.init();
        ConsoleMenu.start();  // логин и пароль для входа : login: 1111 , password: 1111


    }
}
