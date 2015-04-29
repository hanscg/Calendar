/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Lenovo
 */
public class Calendar{
    public Calendar() {
        try {
            File file = new File("");
            URL[] cp = {file.toURI().toURL()};
            URLClassLoader urlcl = new URLClassLoader(cp);
            Class CHandler = urlcl.loadClass("theme.CalendarHandler");
            Class interfaces[] = CHandler.getInterfaces();
            for (Class intf : interfaces) {
                if (intf.getName().equals("Calendar.CalendarView")) {
                    Object calendarShow = CHandler.newInstance();
                    Method method = calendarShow.getClass().getMethod("showCalendar");
                    method.invoke(calendarShow); 
                }
            }
        }
        catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Invalid URL", "Error", ERROR_MESSAGE);
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class Not Found", "Error", ERROR_MESSAGE);
            ex.printStackTrace();
        }
        catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Class Cannot Be Instantiated", "Error", ERROR_MESSAGE);
        }
        catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Illegal Access", "Error", ERROR_MESSAGE);
        }
        catch (NoSuchMethodException ex) {
            JOptionPane.showMessageDialog(null, "Method Not Found", "Error", ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}