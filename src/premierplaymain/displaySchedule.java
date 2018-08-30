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
    List<String> finalizedTeam = new ArrayList<>();

    List<String> finalizedTeam1 = new ArrayList<>();
    List<String> finalizedTeam2 = new ArrayList<>();
    List<Integer> finalizeddayofweek = new ArrayList<>();
    List<Integer> finalizedweek = new ArrayList<>();
    List<String> finalizedymd = new ArrayList<>();

    public displaySchedule(List<String> newArr) {
        initComponents();
        arr = newArr;
        dis();
    }
    public void dis(){
                   int size = arr.size();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String[][] strarr = new String[size / 11][11];
        int counter = 0;
        int count = 0;
        while (size > counter) {
            for (int a = 0; a < 11; a++) {
                strarr[count][a] = arr.get(counter + a);
                System.out.print("  :   " + strarr[count][a] + " :   ");
            }
            System.out.println("");
            count++;
            counter = counter + 11;
        }
        int mer = 0;
        if (arr.get(2).equals("JANUARY")) {
            mer = 1;
        } else if (arr.get(2).equals("FEBRUARY")) {
            mer = 2;
        } else if (arr.get(2).equals("MARCH")) {
            mer = 3;
        } else if (arr.get(2).equals("APRIL")) {
            mer = 4;
        } else if (arr.get(2).equals("MAY")) {
            mer = 5;
        } else if (arr.get(2).equals("JUNE")) {
            mer = 6;
        } else if (arr.get(2).equals("JULY")) {
            mer = 7;
        } else if (arr.get(2).equals("AUGUST")) {
            mer = 8;
        } else if (arr.get(2).equals("SEPTEMBER")) {
            mer = 9;
        } else if (arr.get(2).equals("OCTOBER")) {
            mer = 10;
        } else if (arr.get(2).equals("NOVEMBER")) {
            mer = 11;
        } else if (arr.get(2).equals("DECEMBER")) {
            mer = 12;
        }
        YearMonth yearMonthObject = YearMonth.of(year, Month.valueOf(arr.get(2)));
        int daysInMonth = yearMonthObject.lengthOfMonth(); //28  
        String[] dayOfMonth = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        counter = 0;
        String monthint = "";
        if (arr.get(2).equals("JANUARY")) {
            monthint = "01";
        }
        if (arr.get(2).equals("FEBRUARY")) {
            monthint = "02";
        }
        if (arr.get(2).equals("MARCH")) {
            monthint = "03";
        }
        if (arr.get(2).equals("APRIL")) {
            monthint = "04";
        }
        if (arr.get(2).equals("MAY")) {
            monthint = "05";
        }
        if (arr.get(2).equals("JUNE")) {
            monthint = "06";
        }
        if (arr.get(2).equals("JULY")) {
            monthint = "07";
        }
        if (arr.get(2).equals("AUGUST")) {
            monthint = "08";
        }
        if (arr.get(2).equals("SEPTEMBER")) {
            monthint = "09";
        }
        if (arr.get(2).equals("OCTOBER")) {
            monthint = "10";
        }
        if (arr.get(2).equals("NOVEMBER")) {
            monthint = "11";
        }
        if (arr.get(2).equals("DECEMBER")) {
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
                int mmm = 9999;
                while (strarr.length > count) {
                    String booleanDay = strarr[count][2 + dayOfWeek];
                    int xxx = 999;
                    boolean zzz = false;
                    int dfg = 0;
                    if (booleanDay.equals("true")) {
                        if (Integer.parseInt(strarr[count][10])>1) {
                            for (int lkj = 0; lkj < finalizedTeam1.size(); lkj++) {
                                if (weekNo == finalizedweek.get(lkj)) {
                                    if (finalizedTeam1.get(lkj).equals(strarr[count][0]) || finalizedTeam2.get(lkj).equals(strarr[count][0])) {
                                        dfg++;
                                    }
                                }
                            }
                            System.out.println("ooooooooooooooo"+Integer.parseInt(strarr[count][10])+":::"+strarr[count][0]);
                            if (dfg >Integer.parseInt(strarr[count][10])) {
                                zzz = true;
                            }

                           
                        } else {
                            for (int x = 0; x < finalizedTeam1.size(); x++) {
                                if ((weekNo == finalizedweek.get(x)) && (finalizedTeam1.get(x).equals(strarr[count][0]) || finalizedTeam2.get(x).equals(strarr[count][0]))) {
                                    zzz = true;

                                    break;
                                }
                            }
                        }
                        if (mmm == 9999 && zzz != true) {
                            mmm = count;
                            zzz = false;
                        }

                        if (mmm != 9999 && zzz != true) {

                            boolean xcv = false;
                            for (int ggg = 0; ggg < finalizedTeam1.size(); ggg++) {
                                if (((finalizedTeam1.get(ggg).equals(strarr[mmm][0])) && (finalizedTeam2.get(ggg).equals(strarr[count][0])))) {
                                    xcv = true;
                                    break;
                                }

                            }
                            if (xcv == false && !strarr[mmm][0].equals(strarr[count][0])) {
                                finalizedTeam.add(strarr[mmm][0]);
                                finalizedTeam.add(strarr[count][0]);
                                finalizedTeam1.add(strarr[mmm][0]);
                                finalizedTeam2.add(strarr[count][0]);
                                finalizeddayofweek.add(dayOfWeek);
                                finalizedweek.add(weekNo);
                                finalizedymd.add(ymd);
                                mmm = 9999;
                                zzz = false;

                            }
                            if(xcv == true &&strarr[count][1].equals("YES")&&strarr[mmm][1].equals("YES")){
                                finalizedTeam.add(strarr[mmm][0]);
                                finalizedTeam.add(strarr[count][0]);
                                finalizedTeam1.add(strarr[mmm][0]);
                                finalizedTeam2.add(strarr[count][0]);
                                finalizeddayofweek.add(dayOfWeek);
                                finalizedweek.add(weekNo);
                                finalizedymd.add(ymd);
                                mmm = 9999;
                                zzz = false;
                            }
                        }

                    }
                    count++;
                }
                counter++;
            } catch (ParseException ex) {
                Logger.getLogger(displaySchedule.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            System.out.println(finalizedTeam1.toString());
            System.out.println("==========================");
            System.out.println(finalizedTeam2.toString());
            System.out.println("==========================");
            System.out.println(finalizedweek.toString());

        }
        
        for(int q=0;q<finalizedTeam1.size();q++){
            jTextArea1.append(finalizedTeam1.get(q)+"\t"+finalizedTeam2.get(q)+"\t"+finalizedymd.get(q));
            jTextArea1.append("\n");
        
        }
         


    }
    public void displayer() {
//        int size = arr.size();
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        String[][] strarr = new String[size / 11][11];
//        int counter = 0;
//        int count = 0;
//        while (size > counter) {
//            for (int a = 0; a < 11; a++) {
//                strarr[count][a] = arr.get(counter + a);
//                System.out.print("  :   " + strarr[count][a] + " :   ");
//            }
//            System.out.println("");
//            count++;
//            counter = counter + 11;
//        }
//        int mer = 0;
//        if (arr.get(2).equals("JANUARY")) {
//            mer = 1;
//        } else if (arr.get(2).equals("FEBRUARY")) {
//            mer = 2;
//        } else if (arr.get(2).equals("MARCH")) {
//            mer = 3;
//        } else if (arr.get(2).equals("APRIL")) {
//            mer = 4;
//        } else if (arr.get(2).equals("MAY")) {
//            mer = 5;
//        } else if (arr.get(2).equals("JUNE")) {
//            mer = 6;
//        } else if (arr.get(2).equals("JULY")) {
//            mer = 7;
//        } else if (arr.get(2).equals("AUGUST")) {
//            mer = 8;
//        } else if (arr.get(2).equals("SEPTEMBER")) {
//            mer = 9;
//        } else if (arr.get(2).equals("OCTOBER")) {
//            mer = 10;
//        } else if (arr.get(2).equals("NOVEMBER")) {
//            mer = 11;
//        } else if (arr.get(2).equals("DECEMBER")) {
//            mer = 12;
//        }
//        YearMonth yearMonthObject = YearMonth.of(year, Month.valueOf(arr.get(2)));
//        int daysInMonth = yearMonthObject.lengthOfMonth(); //28  
//        String[] dayOfMonth = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
//            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
//        counter = 0;
//        String monthint = "";
//        if (arr.get(2).equals("JANUARY")) {
//            monthint = "01";
//        }
//        if (arr.get(2).equals("FEBRUARY")) {
//            monthint = "02";
//        }
//        if (arr.get(2).equals("MARCH")) {
//            monthint = "03";
//        }
//        if (arr.get(2).equals("APRIL")) {
//            monthint = "04";
//        }
//        if (arr.get(2).equals("MAY")) {
//            monthint = "05";
//        }
//        if (arr.get(2).equals("JUNE")) {
//            monthint = "06";
//        }
//        if (arr.get(2).equals("JULY")) {
//            monthint = "07";
//        }
//        if (arr.get(2).equals("AUGUST")) {
//            monthint = "08";
//        }
//        if (arr.get(2).equals("SEPTEMBER")) {
//            monthint = "09";
//        }
//        if (arr.get(2).equals("OCTOBER")) {
//            monthint = "10";
//        }
//        if (arr.get(2).equals("NOVEMBER")) {
//            monthint = "11";
//        }
//        if (arr.get(2).equals("DECEMBER")) {
//            monthint = "12";
//        }
//        while (daysInMonth > counter) {
//            try {
//                String ymd = String.valueOf(year) + "-" + monthint + "-" + dayOfMonth[counter];
//                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//                Date todaysDate = sf.parse(ymd);
//                Calendar c = Calendar.getInstance();
//                c.setTime(todaysDate);
//                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//                int weekNo = c.get(Calendar.WEEK_OF_MONTH);
//                count = 0;
//                int mmm = 9999;
//                while (strarr.length > count) {
//                    String booleanDay = strarr[count][2 + dayOfWeek];
//                    int xxx = 999;
//                    boolean zzz = false;
//                    int dfg = 0;
//                    if (booleanDay.equals("true")) {
//                        if (strarr[count][1].equals("YES")) {
//                            for (int lkj = 0; lkj < finalizedTeam1.size(); lkj++) {
//                                if (weekNo == finalizedweek.get(lkj)) {
//                                    if (finalizedTeam1.get(lkj).equals(strarr[count][0]) || finalizedTeam2.get(lkj).equals(strarr[count][0])) {
//                                        dfg++;
//                                    }
//                                }
//                            }
//                            if (dfg > 1) {
//                                zzz = true;
//                            }
//
//                            int qwe = 0;
//                            for (int iop = 0; iop < finalizedTeam1.size(); iop++) {
//                                if (weekNo == finalizedweek.get(iop)) {
//                                    if (finalizedTeam1.get(iop).equals(strarr[count][0]) || finalizedTeam2.get(iop).equals(strarr[count][0])) {
//                                        qwe++;
//                                    }
//                                }
//                            }
//                            if (qwe > 1) {
//                                zzz = true;
//
//                            }
//                        } else {
//                            for (int x = 0; x < finalizedTeam1.size(); x++) {
//                                if ((weekNo == finalizedweek.get(x)) && (finalizedTeam1.get(x).equals(strarr[count][0]) || finalizedTeam2.get(x).equals(strarr[count][0]))) {
//                                    zzz = true;
//
//                                    break;
//                                }
//                            }
//                        }
//                        if (mmm == 9999 && zzz != true) {
//                            mmm = count;
//                            zzz = false;
//                        }
//
//                        if (mmm != 9999 && zzz != true) {
//
//                            boolean xcv = false;
//                            for (int ggg = 0; ggg < finalizedTeam1.size(); ggg++) {
//                                if (((finalizedTeam1.get(ggg).equals(strarr[mmm][0])) && (finalizedTeam2.get(ggg).equals(strarr[count][0])))) {
//                                    xcv = true;
//                                    break;
//                                }
//
//                            }
//                            if (xcv == false && !strarr[mmm][0].equals(strarr[count][0])) {
//                                finalizedTeam.add(strarr[mmm][0]);
//                                finalizedTeam.add(strarr[count][0]);
//                                finalizedTeam1.add(strarr[mmm][0]);
//                                finalizedTeam2.add(strarr[count][0]);
//                                finalizeddayofweek.add(dayOfWeek);
//                                finalizedweek.add(weekNo);
//                                finalizedymd.add(ymd);
//                                mmm = 9999;
//                                zzz = false;
//
//                            }
//
//                        }
//
//                    }
//                    count++;
//                }
//                counter++;
//            } catch (ParseException ex) {
//                Logger.getLogger(displaySchedule.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            
//            System.out.println(finalizedTeam1.toString());
//            System.out.println("==========================");
//            System.out.println(finalizedTeam2.toString());
//            System.out.println("==========================");
//            System.out.println(finalizedweek.toString());
//
//        }
//        
//        for(int q=0;q<finalizedTeam1.size();q++){
//            jTextArea1.append(finalizedTeam1.get(q)+"\t"+finalizedTeam2.get(q)+"\t"+finalizedymd.get(q));
//            jTextArea1.append("\n");
//        
//        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 728));
        setMinimumSize(new java.awt.Dimension(1024, 728));
        setPreferredSize(new java.awt.Dimension(1024, 728));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
