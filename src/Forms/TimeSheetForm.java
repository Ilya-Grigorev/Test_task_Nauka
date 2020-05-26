package Forms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import timesheet.DataBaseClass;

public class TimeSheetForm extends javax.swing.JFrame {

    private int currentYear = 2020;
    private int currentDep_ID = 0;
    private int currentMounth = 1;

    private int NumberOfColumns = 35;

    public TimeSheetForm() {
        initComponents();
        initComponents_Dynamically();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DepartmentList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Тестовое задание для \"Науки\". (сделал Илья Григорьев).");

        jLabel1.setText("Табель");

        jLabel2.setText("Департаменты");

        DepartmentList.setSelectionBackground(new java.awt.Color(204, 255, 204));
        DepartmentList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DepartmentListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(DepartmentList);

        jButton1.setText("Пересоздать все таблицы в базе");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1))
        );

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

        // Получение выделенной вкладки
        JPanel panel = (JPanel) ((JTabbedPane) evt.getSource()).getSelectedComponent();
        int panel_index = jTabbedPane1.indexOfComponent(panel);

        currentMounth = panel_index + 1;
        if (currentMounth < 1) {
            currentMounth = 1;
        }

        init_TimeSheetTable();

    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // Пересоздаются все таблицы в базе данных.

        DataBaseClass.createTablesInDB();

        // initComponents();
        initComponents_Dynamically();
        init_TimeSheetTable();

    }//GEN-LAST:event_jButton1MouseClicked

    private void DepartmentListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DepartmentListValueChanged

        if (evt.getValueIsAdjusting() == true) {

            currentDep_ID = 0;
            int ListInd = ((JList) evt.getSource()).getSelectedIndex();
            String Depatm = DepartmentList.getModel().getElementAt(ListInd);

            try {

                DataBaseClass.getMyConnection();
                String query = "SELECT * FROM USER1.DEPARTMENTS where DEP_NAME=?";
                PreparedStatement pst = DataBaseClass.myConnection.prepareStatement(query);
                pst.setString(1, Depatm);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    currentDep_ID = rs.getInt("DEP_ID");
                    break;
                }
            } catch (SQLException ex) {
            }

            init_TimeSheetTable();

        }

    }//GEN-LAST:event_DepartmentListValueChanged

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

        if (evt.getPropertyName() == "tableCellEditor") {

            DefaultCellEditor val = (DefaultCellEditor) evt.getOldValue();

            if (val != null) {
                //String NewValue=val

                String NewValue = val.getCellEditorValue().toString();

                int col_id = ((JTable) evt.getSource()).getEditingColumn();
                int row_id = ((JTable) evt.getSource()).getEditingRow();

                int myday = col_id - 3;
                int tab_number = (int) jTable1.getModel().getValueAt(row_id, 2);

                String strDate = "" + currentYear + "," + currentMounth + "," + myday + ",00,00";
                java.sql.Date myDate = DataBaseClass.get_SQL_Date(strDate);

                DataBaseClass.MakeRecord_In_TIME_SHEET(myDate, tab_number, NewValue);

                RecountSummary(row_id);

            }

        }


    }//GEN-LAST:event_jTable1PropertyChange

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TimeSheetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeSheetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeSheetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeSheetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeSheetForm().setVisible(true);
            }
        });
    }

    public void initComponents_Dynamically() {

        // Выводим список департаментов:
        ArrayList<String> department_list = DataBaseClass.getDepartmentsList();
        String[] dep = department_list.toArray(new String[department_list.size()]);

        DepartmentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = dep;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });

        // Выводим закладки с месяцами:
        String[] months = DataBaseClass.getMonths();

        jTabbedPane1.removeAll();
        for (int i = 0; i < months.length; i++) {
            String tabName = months[i];
            javax.swing.JPanel jTabbedPane_local = new javax.swing.JPanel();
            jTabbedPane1.addTab(tabName, jTabbedPane_local);
        }

        init_TimeSheetTable();

    }

    public void init_TimeSheetTable() {

        // Первый день текущего месяца:
        String strDate = "" + currentYear + "," + currentMounth + ",01,00,00";
        java.sql.Date firstDayOfCurrentMounth = DataBaseClass.get_SQL_Date(strDate);

        // Последний день текущего месяца:
        LocalDate localDate = LocalDate.of(currentYear, currentMounth, 1);
        TemporalAdjuster lastDayOfMonth = TemporalAdjusters.lastDayOfMonth();
        int LastDay = localDate.with(lastDayOfMonth).getDayOfMonth();
        strDate = "" + currentYear + "," + currentMounth + "," + LastDay + ",00,00";
        java.sql.Date LastDayOfCurrentMounth = DataBaseClass.get_SQL_Date(strDate);

        // Оформляем таблицу:
        String[] ColumnNames = new String[NumberOfColumns];
        int[] ColumnWidth = new int[NumberOfColumns];

        ColumnNames[0] = "ФИО";
        ColumnWidth[0] = 100;

        ColumnNames[1] = "Должность";
        ColumnWidth[1] = 100;

        ColumnNames[2] = "Табельный №";
        ColumnWidth[2] = 100;

        ColumnNames[3] = "Итого";
        ColumnWidth[3] = 200;

        for (int i = 1; i <= 31; i++) {
            ColumnNames[3 + i] = "" + i;
            ColumnWidth[3 + i] = 50;
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                ColumnNames
        ) {
            public boolean isCellEditable(int row, int column) {

                if (column < 4) {
                    return false;
                }

                if (column > LastDay + 3) {
                    return false;
                }

                return true;//This causes all cells to be not editable
            }
        });

        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTable1);

        // Ограничиваем выбор из списка меток
        ArrayList<String> mk = DataBaseClass.getMarks();
        mk.add("");
        String[] marks = mk.toArray(new String[mk.size()]);
        JComboBox<String> combo = new JComboBox<String>(marks);
        DefaultCellEditor editor = new DefaultCellEditor(combo);

        // Устанавливаем ширину столбцов.
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
                jTable1.getColumnModel().getColumn(i).setPreferredWidth(ColumnWidth[i]);

                if (i > 3) {
                    jTable1.getColumnModel().getColumn(i).setCellEditor(editor);
                }
            }
        }

        //////// Заполняем таблицу данными:
        // Получаем список сотрудников текущего подразделения:
        if (currentDep_ID > 0 && currentMounth > 0) {

            DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();

            HashMap<Integer, Integer> Sootv = new HashMap<>(); // Храню соответствие между табельным номером и строки таблицы, где этот номер отображается.

            try {
                DataBaseClass.getMyConnection();

                String query = "SELECT * FROM USER1.EMPLOYEES where DEP_ID=?";
                PreparedStatement pst = DataBaseClass.myConnection.prepareStatement(query);

                pst.setInt(1, currentDep_ID);
                ResultSet rs = pst.executeQuery();

                int Sch = 0;

                try {
                    while (rs.next()) {

                        Object[] objects = new Object[NumberOfColumns];

                        objects[0] = rs.getString("EMPLOYEE_NAME");
                        objects[1] = rs.getString("POSITION");

                        int Emp_ID = rs.getInt("EMPLOYEE_ID");
                        objects[2] = Emp_ID;

                        aModel.addRow(objects);
                        Sootv.put(Emp_ID, Sch);
                        Sch++;
                    }
                } catch (SQLException ex) {
                }

            } catch (SQLException ex) {
                System.out.println("Не удалось выполнить запрос.");
            }

            // Получаем данные из табеля:
            try {
                DataBaseClass.getMyConnection();
                String query = "SELECT * FROM USER1.TIME_SHEET where EMPLOYEE_ID in (SELECT EMPLOYEE_ID from EMPLOYEES where DEP_ID=?) and date>=? and date<=?";
                PreparedStatement pst = DataBaseClass.myConnection.prepareStatement(query);

                pst.setInt(1, currentDep_ID);

                pst.setDate(2, firstDayOfCurrentMounth);
                pst.setDate(3, LastDayOfCurrentMounth);

                ResultSet rs = pst.executeQuery();

                int Sch = 0;

                try {
                    while (rs.next()) {

                        int ID = rs.getInt("EMPLOYEE_ID");
                        Date md = rs.getDate("DATE");

                        SimpleDateFormat format1 = new SimpleDateFormat("dd");
                        int dayOfMounth = Integer.parseInt(format1.format(md));
                        int IndInTab = dayOfMounth + 3;
                        String mark = rs.getString("MARK");

                        int IndOfRow = Sootv.get(ID);

                        aModel.setValueAt(mark, IndOfRow, IndInTab);

                    }
                } catch (SQLException ex) {
                }

            } catch (SQLException ex) {
                System.out.println("Не удалось выполнить запрос.");
            }

            // Пересчитываю итоги в строках таблицы:
            if (jTable1.getRowCount() > 0) {
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    RecountSummary(i);
                }
            }

        }

    }

    private void RecountSummary(int numOfRow) {

        DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();

        HashMap<String, Integer> Summary = new HashMap<>();

        //System.out.println("Строка " + numOfRow);
        for (int i = 4; i < NumberOfColumns; i++) {

            String metka = (String) aModel.getValueAt(numOfRow, i);

            if (metka != null) {
                if (!metka.equals("")) {

                    // System.out.println("Столбец  " + i + " значение " + metka);
                    Integer IndOfRow = Summary.get(metka);

                    if (IndOfRow == null) {
                        Summary.put(metka, 1);
                    } else {
                        Summary.put(metka, IndOfRow + 1);
                    }
                }
            }
        }

        String Summ = "";

        for (Map.Entry<String, Integer> entry : Summary.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            Summ = Summ + key + "(" + value + ");";
        }

        aModel.setValueAt(Summ, numOfRow, 3);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> DepartmentList;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
