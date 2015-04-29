/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar;

/**
 *
 * @author user
 */
public class CalendarCommand implements Command {
   
    private CalendarReceiver receiver;
    
    public CalendarCommand(CalendarReceiver calendarreceiver) {
        receiver = calendarreceiver ;
    }
    
    @Override 
    public void execute(){
       receiver.drawCalendar();
    }
}
