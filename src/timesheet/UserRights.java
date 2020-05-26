package timesheet;

import Forms.LoginForm;
import java.util.HashMap;
import java.util.Map;

public class UserRights {

    // Роли пользователей пока храню в хеш-мепе, возможно позже лучше будет перенести в SQL-таблицу.
    public static Map<String, Integer> UsersRoles = new HashMap<String, Integer>();
    public static String CurrentUserRole;

    public static void InitConstants() {

        UsersRoles.clear();

        UsersRoles.put("табельщик", 1);
        UsersRoles.put("администратор справочника отделов (специалист отдела кадров)", 2);
        UsersRoles.put("администратор справочника работников (специалист отдела кадров)", 3);

        // Разработчику можно все.
        UsersRoles.put("разработчик", 4);

    }

    public static void DefineUserRole() {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });

    }

}
