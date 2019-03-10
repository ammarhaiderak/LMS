/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L164249_LMS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ammar
 */
public class renewItem extends javax.swing.JFrame {
private BAL controllor;
private ArrayList<Loan> loans;
    /**
     * Creates new form renewItem
     */
    public renewItem() {
        initComponents();
        
        controllor=new BAL();
        
        loans=controllor.getloans2();
        setList();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        datechooser.setDateFormat(sdf);
        
        this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        
    }

     private void setList(/*ArrayList<String>t*/){
        
        ArrayList<String> temp=new ArrayList<String>();
        for(int i=0;i<loans.size();++i){
        temp.add(loans.get(i).getU_ID()+" | "+
                loans.get(i).getBKID()+" | "+
                loans.get(i).getISSUE_DATE()+" | "+
                loans.get(i).getRETURN_DATE()
                );
        
        }
    
         javax.swing.JList<String> tt=new javax.swing.JList(temp.toArray());
          
         jList1=tt;
         
         jScrollPane1.setViewportView(jList1);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        dateChooserPanel2 = new datechooser.beans.DateChooserPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        datechooser = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("RENEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LOANS");

        jLabel2.setText("NEW DATE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // TODO add your handling code here:
         DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        // String d=String.valueOf(dateChooser.getDateFormat());   
       
        
        
         
         Date d1=null;
         
         
         Date d2=null;
         String selectedDate=null;
         try{
         //String s2=(sdf.format(dateChooser.getDateFormat().getCalendar().getTime()));//Format().getCalendar().getTime();
         String rdate=loans.get(jList1.getSelectedIndex()).getRETURN_DATE();
         //String[]t=rdate.split("-");
         //String nrdate=t[0]+"/"+t[1]+"/"+t[2];
         System.out.println(rdate);
    //     System.out.println("selected"+s2);
    
         d2=sdf.parse(rdate);
         selectedDate=datechooser.getText();
         d1=sdf.parse(selectedDate);//selected date in chooser
         
         
         
         }
         catch(Exception e){
         
             JOptionPane.showMessageDialog(this, e.toString());
         }
         
         if(d1.compareTo(d2)<0){
             JOptionPane.showMessageDialog(this,"Enter a Date greater than previous Return Date");
         
         }
         else{   
         //String uid,String bid,String retdate
        String uid= loans.get(jList1.getSelectedIndex()).getU_ID();
            
        String bid= loans.get(jList1.getSelectedIndex()).getBKID();
         
        //String d=String.valueOf(d1);
        
        System.out.println(uid+" "+bid+" "+selectedDate);
        controllor.renewItem(uid, bid, selectedDate);
        loans=controllor.getloans2();
        int prevSelection=jList1.getSelectedIndex();
        
        renewItem.this.setList();
        jList1.setSelectedIndex(prevSelection);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private datechooser.beans.DateChooserPanel dateChooserPanel2;
    private datechooser.beans.DateChooserCombo datechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
