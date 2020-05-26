package timesheet;

import Forms.TimeSheetForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseClass {

    public static Connection myConnection = null;

    public static Statement myStatment = null;
    public static ResultSet myResultSet = null;

    private static final String DB_URL = "jdbc:derby://localhost:1527/TimeSheetDataBase";
    private static final String DB_User = "User1";
    private static final String DB_PassWord = "5432";

    public static Connection getMyConnection() {
        // Получаем подключение к базе данных (25.05.2020)

        if (myConnection == null) {

            try {
                myConnection = DriverManager.getConnection(DB_URL, DB_User, DB_PassWord);
            } catch (SQLException ex) {

                System.out.println("Не удалось установить соединение с базой данных.");
                System.exit(0);
            }
        }

        return myConnection;
    }

    public static ResultSet getMyResultSet(String query) {
        // Выполняем запрос к базе данных (25.05.2020)

        try {
            getMyConnection();
            myStatment = myConnection.createStatement();
            myResultSet = myStatment.executeQuery(query);

            return myResultSet;

        } catch (SQLException ex) {
            System.out.println("Не удалось выполнить запрос.");
            System.out.println(query);
        }

        return null;

    }

    public static ArrayList<String> getDepartmentsList() {

//        String ListOfDepartments[] = new String[3];
//        ListOfDepartments[0] = "Департамент антипригарных стульев";
//        ListOfDepartments[1] = "Разработка цветочных фреймворков";
//        ListOfDepartments[2] = "PR станков и горшков";
        String query = "SELECT * FROM USER1.DEPARTMENTS";
        ResultSet rs = getMyResultSet(query);

        ArrayList<String> al = new ArrayList();

        if (rs != null) {
            try {
                while (rs.next()) {
                    al.add((rs.getString("DEP_NAME")).trim());
                }
            } catch (SQLException ex) {
            }
        }

        return al;
    }

    public static ArrayList<String> getMarks() {

        String query = "SELECT * FROM USER1.MARKS";
        ResultSet rs = getMyResultSet(query);

        ArrayList<String> al = new ArrayList();

        if (rs != null) {
            try {
                while (rs.next()) {
                    al.add((rs.getString("MARK_ID")).trim());
                }
            } catch (SQLException ex) {
            }
        }

        return al;
    }

    public static void createTablesInDB() {

        createTableMARKS();
        createTableDEPARTMENTS();
        createTableEMPLOYEES();
        createTable_TIME_SHEET();

    }

    public static void createTableMARKS() {
        // Создаем в базе данных таблицу "Marks" (25.05.2020)

        try {
            getMyConnection();
            myStatment = myConnection.createStatement();

            try {
                myStatment.executeUpdate("drop table MARKS");
            } catch (SQLException ex) {
                System.out.println("Не удалось Удалить таблицу Marks");
            }

            myStatment.executeUpdate("create table MARKS (MARK_ID char(2) unique)");

            String[] values = new String[]{"Я", "Н", "В", "Рв", "Б", "К", "ОТ", "До", "Хд", "У", "Ож", "Хз"};

            for (String value : values) {
                String qu = "insert into MARKS (MARK_ID) values ('" + value + "')";
                myStatment.executeUpdate(qu);
            }

        } catch (SQLException ex) {
            System.out.println("Не удалось создать в базе данных таблицу MARKS (отметки)");
        }

    }

    public static void createTableDEPARTMENTS() {
        // Создаем в базе данных таблицу "DEPARTMENTS" (25.05.2020)

        try {
            getMyConnection();
            myStatment = myConnection.createStatement();

            try {
                myStatment.executeUpdate("drop table DEPARTMENTS");
            } catch (SQLException ex) {
                System.out.println("Не удалось Удалить таблицу DEPARTMENTS");
            }

            myStatment.executeUpdate("create table DEPARTMENTS (DEP_ID INTEGER unique not null, DEP_NAME  char(150) unique not null )");

            myStatment.executeUpdate("insert into DEPARTMENTS values (1, 'Департамент антипригарных стульев')");
            myStatment.executeUpdate("insert into DEPARTMENTS values (2, 'Разработка цветочных фреймворков')");
            myStatment.executeUpdate("insert into DEPARTMENTS values (3, 'PR станков и горшков')");
            myStatment.executeUpdate("insert into DEPARTMENTS values (4, 'Тестовое подр.')");

        } catch (SQLException ex) {
            System.out.println("Не удалось создать в базе данных таблицу DEPARTMENTS");
        }

    }

    public static void createTableEMPLOYEES() {
        // Создаем в базе данных таблицу "EMPLOYEES" (25.05.2020)

        try {
            getMyConnection();
            myStatment = myConnection.createStatement();

            try {
                myStatment.executeUpdate("drop table EMPLOYEES");
            } catch (SQLException ex) {
                System.out.println("Не удалось Удалить таблицу EMPLOYEES");
            }

            String qu = "create table EMPLOYEES ("
                    + "EMPLOYEE_NAME char(100) not null,"
                    + " EMPLOYEE_ID INTEGER unique not null,"
                    + " POSITION char(50) not null,"
                    + " DEP_ID INTEGER not null"
                    + ")";

            myStatment.executeUpdate(qu);

            // подр. 1
            myStatment.executeUpdate("insert into EMPLOYEES values ('Иванов И.', 123 ,  'повар', 1)");
            myStatment.executeUpdate("insert into EMPLOYEES values ('Петров П.', 124 ,  'кондитер', 1)");
            myStatment.executeUpdate("insert into EMPLOYEES values ('Сидоров С.', 125 ,  'пекарь', 1)");

            myStatment.executeUpdate("insert into EMPLOYEES values ('Одуванчиков О.', 255 ,  'цветочник', 2)");
            myStatment.executeUpdate("insert into EMPLOYEES values ('Лютиков Л.', 256,  'горшочник', 2)");
            myStatment.executeUpdate("insert into EMPLOYEES values ('Фиалкин Ф.', 257 ,  'цветочник', 2)");

            myStatment.executeUpdate("insert into EMPLOYEES values ('Токарев Т.', 301 ,  'станочник', 3)");
            myStatment.executeUpdate("insert into EMPLOYEES values ('Макаров М.', 302,  'техник', 3)");
            myStatment.executeUpdate("insert into EMPLOYEES values ('Калашников К.', 303 ,  'станочник', 3)");

            myStatment.executeUpdate("insert into EMPLOYEES values ('Тестовый Т.', 444 ,  'цветочник', 4)");

//            myStatment.executeUpdate("insert into DEPARTMENTS values (1, 'Департамент антипригарных стульев')");
//            myStatment.executeUpdate("insert into DEPARTMENTS values (2, 'Разработка цветочных фреймворков')");
//            myStatment.executeUpdate("insert into DEPARTMENTS values (3, 'PR станков и горшков')");
//            myStatment.executeUpdate("insert into DEPARTMENTS values (4, 'Тестовое подр.')");
        } catch (SQLException ex) {
            System.out.println("Не удалось создать в базе данных таблицу EMPLOYEES");
        }

    }

    public static void createTable_TIME_SHEET() {
        // Создаем в базе данных таблицу "TIME_SHEET" (25.05.2020)

        try {
            getMyConnection();
            myStatment = myConnection.createStatement();

            try {
                myStatment.executeUpdate("drop table TIME_SHEET");
            } catch (SQLException ex) {
                System.out.println("Не удалось Удалить таблицу TIME_SHEET");
            }

            String qu = "create table TIME_SHEET ("
                    + " DATE date not null,"
                    + " EMPLOYEE_ID INTEGER not null,"
                    + " MARK char(2) not null,"
                    + " CONSTRAINT TIME_SHEET_PK PRIMARY KEY (DATE, EMPLOYEE_ID)"
                    + ")";

            myStatment.executeUpdate(qu);

        } catch (SQLException ex) {
            System.out.println("Не удалось создать в базе данных таблицу TIME_SHEET");
        }

    }

    public static boolean MakeRecord_In_TIME_SHEET(java.sql.Date myDate, int empID, String mark) {

        try {
            String query = "insert into TIME_SHEET values (?, ?, ?)";
            PreparedStatement pst = myConnection.prepareStatement(query);

            pst.setDate(1, myDate);
            pst.setInt(2, empID);
            pst.setString(3, mark);

            pst.executeUpdate();

        } catch (SQLException ex) {
            try {
                getMyConnection();
                String query = "update USER1.TIME_SHEET "
                        + "SET mark =  ? "
                        + "where EMPLOYEE_ID=? and date=?";

                PreparedStatement pst;

                pst = myConnection.prepareStatement(query);

                pst.setDate(3, myDate);
                pst.setInt(2, empID);
                pst.setString(1, mark);

                pst.executeUpdate();
            } catch (SQLException ex1) {
                System.out.println("Не удалось сделать запись в таблицу TIME_SHEET");
            }

        }

        return true;

    }

    public static java.sql.Date get_SQL_Date(String StrDate) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy,MM,dd,HH,mm");
        Date myDate = new Date();
        try {
            myDate = format.parse(StrDate);
        } catch (ParseException ex) {
            Logger.getLogger(TimeSheetForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        return sqlDate;

    }

    public static String[] getMonths() {
        // Для тестирования

        String Months[] = new String[12];

        Months[0] = "Январь";
        Months[1] = "Февраль";
        Months[2] = "Март";
        Months[3] = "Апрель";
        Months[4] = "Май";
        Months[5] = "Июнь";
        Months[6] = "Июль";
        Months[7] = "Август";
        Months[8] = "Сентябрь";
        Months[9] = "Октябрь";
        Months[10] = "Ноябрь";
        Months[11] = "Декабрь";

        return Months;

    }

}
