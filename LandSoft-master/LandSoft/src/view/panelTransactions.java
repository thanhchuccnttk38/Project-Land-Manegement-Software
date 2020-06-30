/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Transactions;

/**
 *
 * @author Group1
 */
public final class panelTransactions extends javax.swing.JPanel {

    /**
     * Creates new form panelTransactions
     */
    void initTableTransaction() {
        try {
            Vector vCol = new Vector();
            vCol.add("No.");
            vCol.add("TransactionID");
            vCol.add("PropertyID");
            vCol.add("CustomerID");
            vCol.add("Date");
            vCol.add("Final Price");

            Vector vData = new Vector();
            List<Transactions> list = controller.TransactionsController.getListTransactions();
            int countRow = 0;
            for (Transactions transactions : list) {
                Vector vTemp = new Vector();
                countRow++;
                vTemp.add(countRow);
                vTemp.add(transactions.getTransactionID());
                vTemp.add(transactions.getPropertyID());
                vTemp.add(transactions.getCustomerID());
                vTemp.add(transactions.getDate());
                vTemp.add(transactions.getFinalPrice());
                vData.add(vTemp);
            }
            DefaultTableModel model = new DefaultTableModel(vData, vCol);
            tblTransaction.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void initGUIPanel() {
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

    }

    void findTransaction() {
        TableRowSorter rowSorter = new TableRowSorter(tblTransaction.getModel());
        tblTransaction.setRowSorter(rowSorter);
        txtFind.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                String text = txtFind.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text = txtFind.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {

            }
        });
    }

    public panelTransactions() {
        initComponents();
        initTableTransaction();
        initGUIPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtTransactionID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chooserDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtFinalFirce = new javax.swing.JTextField();
        spinPropertyID = new javax.swing.JSpinner();
        spinCustomerID = new javax.swing.JSpinner();

        setLayout(new java.awt.BorderLayout());

        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tblTransaction.setRowHeight(25);
        tblTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransactionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaction);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_search.png"))); // NOI18N
        jLabel1.setText("Find :");

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFindMouseClicked(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon-add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("TransactionID:");

        txtTransactionID.setEditable(false);
        txtTransactionID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("PropertyID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("CustomerID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Date:");

        chooserDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("FinalFrice:");

        txtFinalFirce.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        spinPropertyID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinPropertyID.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinCustomerID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinCustomerID.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTransactionID)
                            .addComponent(spinPropertyID, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(spinCustomerID))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(chooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtFinalFirce)))))
                .addContainerGap(465, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(chooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtFinalFirce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinPropertyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spinCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransactionMouseClicked
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        int index = tblTransaction.getSelectedRow();

        String transactionID = tblTransaction.getValueAt(index, 1).toString();
        txtTransactionID.setText(transactionID);
        int propertyID = Integer.parseInt(tblTransaction.getValueAt(index, 2).toString());
        spinPropertyID.setValue(propertyID);
        int customerID = Integer.parseInt(tblTransaction.getValueAt(index, 3).toString());
        spinCustomerID.setValue(customerID);

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tblTransaction.getValueAt(index, 4).toString());
            chooserDate.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(panelTransactions.class.getName()).log(Level.SEVERE, null, ex);
        }
        String finalFrice = tblTransaction.getValueAt(index, 5).toString();
        txtFinalFirce.setText(finalFrice);

    }//GEN-LAST:event_tblTransactionMouseClicked

    private void txtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFindMouseClicked
        findTransaction();
    }//GEN-LAST:event_txtFindMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        initTableTransaction();
        initGUIPanel();

        txtTransactionID.setText("");
        spinPropertyID.setValue(0);
        spinCustomerID.setValue(0);
        chooserDate.setDate(null);
        txtFinalFirce.setText("");

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            int propertyID = Integer.parseInt(spinPropertyID.getValue().toString());
            int customerID = Integer.parseInt(spinCustomerID.getValue().toString());
            String finalPrice = txtFinalFirce.getText();

            //kiểm tra propertyID đã tồn tại chưa ?
            if (!controller.TransactionsController.checkExistPropertyID(propertyID)) {
                JOptionPane.showMessageDialog(null, "PropertyID not exist !");
                spinPropertyID.requestFocus();
                return;
            }
            //kiểm tra CustomerID đã tồn tại chưa ?
            if (!controller.TransactionsController.checkExistCustomerID(customerID)) {
                JOptionPane.showMessageDialog(null, "CustomerID not exist !");
                spinCustomerID.requestFocus();
                return;
            }

            String date;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = dateFormat.format(chooserDate.getDate());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Not choose Date");
                chooserDate.requestFocus();
                return;
            }
            if (finalPrice.isEmpty() || finalPrice.length() > 20) {
                JOptionPane.showMessageDialog(null, "Final price not be empty or more than 20 character!");
                txtFinalFirce.requestFocus();
                return;
            }
            try {
                Integer.parseInt(finalPrice);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Final price must be a number");
                txtFinalFirce.requestFocus();
                return;
            }

            int index = JOptionPane.showConfirmDialog(null, "Are you want to Add new transaction ?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                controller.TransactionsController.addNewTransaction(propertyID, customerID, date, finalPrice);
                btnRefreshActionPerformed(evt);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int transactionID = Integer.parseInt(txtTransactionID.getText());
            int propertyID = Integer.parseInt(spinPropertyID.getValue().toString());
            int customerID = Integer.parseInt(spinCustomerID.getValue().toString());
            String finalPrice = txtFinalFirce.getText();

            //kiểm tra propertyID có tồn tại không ?
            if (!controller.TransactionsController.checkExistPropertyID(propertyID)) {
                JOptionPane.showMessageDialog(null, "PropertyID not exist !");
                spinPropertyID.requestFocus();
                return;
            }
            //kiểm tra CustomerID có tồn tại không ?
            if (!controller.TransactionsController.checkExistCustomerID(customerID)) {
                JOptionPane.showMessageDialog(null, "CustomerID not exist !");
                spinCustomerID.requestFocus();
                return;
            }

            String date;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = dateFormat.format(chooserDate.getDate());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Not choose Date");
                chooserDate.requestFocus();
                return;
            }
            if (finalPrice.isEmpty() || finalPrice.length() > 20) {
                JOptionPane.showMessageDialog(null, "Final price not be empty or more than 20 character!");
                txtFinalFirce.requestFocus();
                return;
            }
            try {
                Integer.parseInt(finalPrice);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Final price must be a number");
                txtFinalFirce.requestFocus();
                return;
            }

            int index = JOptionPane.showConfirmDialog(null, "Are you want to Update transaction ?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                controller.TransactionsController.updateTransaction(transactionID, propertyID, customerID, date, finalPrice);
                btnRefreshActionPerformed(evt);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int transactionID = Integer.parseInt(txtTransactionID.getText());

        int index = JOptionPane.showConfirmDialog(null, "Are you want to Delete transaction ?", "Notification", JOptionPane.YES_NO_OPTION);
        if (index == JOptionPane.YES_OPTION) {
            try {
                controller.TransactionsController.deleteTransaction(transactionID);
                btnRefreshActionPerformed(evt);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(panelTransactions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(panelTransactions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser chooserDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spinCustomerID;
    private javax.swing.JSpinner spinPropertyID;
    private javax.swing.JTable tblTransaction;
    private javax.swing.JTextField txtFinalFirce;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtTransactionID;
    // End of variables declaration//GEN-END:variables
}
