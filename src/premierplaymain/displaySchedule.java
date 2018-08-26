/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierplaymain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nissanka
 */
public class displaySchedule extends javax.swing.JFrame {

    /**
     * Creates new form displaySchedule
     */
    List<String> arr = new ArrayList<>();
    List<String> finalizedTeam1 = new ArrayList<>();
    List<String> finalizedTeam2 = new ArrayList<>();
    List<Integer> finalizeddayofweek = new ArrayList<>();
    List<Integer> finalizedweek = new ArrayList<>();
    List<String> finalizedymd = new ArrayList<>();

    public displaySchedule(List<String> newArr) {
        initComponents();
        arr = newArr;
        displayer();
    }

    public void displayer() {
        int size = arr.size();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String[][] strarr = new String[size][10];
        int counter = 0;
        int count = 0;
        while (size > counter) {
            for (int a = 0; a < 10; a++) {
                strarr[count][a] = arr.get(counter + a);
                System.out.print("  :   " + strarr[count][a] + " :   ");
            }
            System.out.println("");
            count++;
            counter = counter + 10;
        }
        YearMonth yearMonthObject = YearMonth.of(year, Month.valueOf(arr.get(9)));
        int daysInMonth = yearMonthObject.lengthOfMonth(); //28  
        String[] dayOfMonth = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        counter = 0;
        String monthint = "";
        if (arr.get(9).equals("JANUARY")) {
            monthint = "01";
        }
        if (arr.get(9).equals("FEBRUARY")) {
            monthint = "02";
        }
        if (arr.get(9).equals("MARCH")) {
            monthint = "03";
        }
        if (arr.get(9).equals("APRIL")) {
            monthint = "04";
        }
        if (arr.get(9).equals("MAY")) {
            monthint = "05";
        }
        if (arr.get(9).equals("JUNE")) {
            monthint = "06";
        }
        if (arr.get(9).equals("JULY")) {
            monthint = "07";
        }
        if (arr.get(9).equals("AUGUST")) {
            monthint = "08";
        }
        if (arr.get(9).equals("SEPTEMBER")) {
            monthint = "09";
        }
        if (arr.get(9).equals("OCTOBER")) {
            monthint = "10";
        }
        if (arr.get(9).equals("NOVEMBER")) {
            monthint = "11";
        }
        if (arr.get(9).equals("DECEMBER")) {
            monthint = "12";
        }
        while (daysInMonth > counter) {
            try {
                String ymd = String.valueOf(year) + "-" + monthint + "-" + dayOfMonth[counter];
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date todaysDate = sf.parse(ymd);
                Calendar c = Calendar.getInstance();
                c.setTime(todaysDate);
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                int weekNo = c.get(Calendar.WEEK_OF_MONTH);
                count = 0;

                while (strarr.length > count) {
                    String booleanDay = strarr[count][2 + dayOfWeek];
                    int xxx = 999;
                    int yyy = 999;
                    if (booleanDay.equals("true")) {
                        if (strarr[count][1].equals("YES")) {

                        } else {
                            for (int x = 0; x < finalizedTeam1.size(); x++) {
                                if ((weekNo == finalizedweek.get(x))&&strarr[count][0].equals(finalizedTeam1.get(x))) {
                                    xxx = 1;
                                    yyy = 888;
                                    break;
                                }
                            }
//                            if (yyy != 888) {
//                                for (int x = 0; x < finalizedTeam2.size(); x++) {
//                                    if ((weekNo == finalizedweek.get(x))&&strarr[count][0].equals(finalizedTeam2.get(x))) {                                        xxx = 1;
//                                        yyy = 888;
//                                        break;
//                                    }
//                                }
//                            }
                        }
                        if(xxx!=1){
                            
                            //SEARCH FOR THE MATCHING TEAM HERE THEN ADD THE TEAMS TO THE LISTS 
                        
                        }
                    }
                    count++;
                }
                counter++;
            } catch (ParseException ex) {
                Logger.getLogger(displaySchedule.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 728));
        setMinimumSize(new java.awt.Dimension(1024, 728));
        setPreferredSize(new java.awt.Dimension(1024, 728));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(displaySchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(displaySchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(displaySchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(displaySchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                List<String> af = new ArrayList<String>();
                new displaySchedule(af).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
