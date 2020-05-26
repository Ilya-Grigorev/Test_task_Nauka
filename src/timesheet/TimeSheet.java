package timesheet;

import Forms.TimeSheetForm;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeSheet {

    public static void main(String[] args) {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeSheetForm().setVisible(true);
            }
        });

    }

}
