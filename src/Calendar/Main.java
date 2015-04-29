package Calendar;

public class Main {

    public static void main(String[] args) {
        CalendarReceiver receiver = new CalendarReceiver();
        
        Command calendar = new CalendarCommand(receiver);
        
        calendar.execute();
    }
}
