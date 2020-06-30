/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Images;

/**
 *
 * @author Group1
 */
public final class panelPropertyImage extends javax.swing.JPanel {

    /**
     * Creates new form panelPropertyImage
     */
    File selectedPicture = null;
    byte[] image = null;

    void initTablePropertyImage() {
        try {
            Vector vCol = new Vector();
            vCol.add("No.");
            vCol.add("ImageID");
            vCol.add("PropertyID");
            vCol.add("Image");
            Vector vData = new Vector();
            int countRow = 0;
            List<Images> listImages = controller.ImagesController.getListImages();
            for (Images images : listImages) {
                Vector vTemp = new Vector();
                countRow++;
                vTemp.add(countRow);
                vTemp.add(images.getImageID());
                vTemp.add(images.getPropertyID());
                vTemp.add(images.getImage());
                vData.add(vTemp);
            }
            DefaultTableModel model = new DefaultTableModel(vData, vCol);
            tblPropertyImage.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void initGUIPanelPropertyImage() {
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    void findPropertyImage() {
        TableRowSorter rowSorter = new TableRowSorter(tblPropertyImage.getModel());
        tblPropertyImage.setRowSorter(rowSorter);
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

    void copyImageIntoLandSoft() {
        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/images";
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdir();
            }
            dir += "/" + selectedPicture.getName();
            Path copied = Paths.get(dir);
            Path originalPath = Paths.get(selectedPicture.getAbsolutePath());
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public panelPropertyImage() {
        initComponents();
        initTablePropertyImage();
        initGUIPanelPropertyImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPropertyImage = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtImageID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        spinPropertyID = new javax.swing.JSpinner();

        setLayout(new java.awt.BorderLayout());

        tblPropertyImage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPropertyImage.setRowHeight(25);
        tblPropertyImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPropertyImageMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPropertyImage);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.LINE_START);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("ImageID:");

        txtImageID.setEditable(false);
        txtImageID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("PropertyID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Image:");

        btnChooseImage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnChooseImage.setText("Choose Image");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Find:");

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

        spinPropertyID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinPropertyID.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(spinPropertyID))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(30, 30, 30)
                            .addComponent(txtImageID, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtImageID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinPropertyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnChooseImage))
                .addGap(18, 18, 18)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblPropertyImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPropertyImageMouseClicked
        try {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);

            int index = tblPropertyImage.getSelectedRow();
            txtImageID.setText(tblPropertyImage.getValueAt(index, 1).toString());
            spinPropertyID.setValue(Integer.parseInt(tblPropertyImage.getValueAt(index, 2).toString()));

            image = controller.ImagesController.getListImages().get(index).getImage();
            ImageIcon icon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
            lblImage.setIcon(icon);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tblPropertyImageMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        initTablePropertyImage();
        initGUIPanelPropertyImage();

        txtImageID.setText("");
        spinPropertyID.setValue(0);
        lblImage.setIcon(null);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            int propertyID = Integer.parseInt(spinPropertyID.getValue().toString());
            if (!controller.TransactionsController.checkExistPropertyID(propertyID)) {
                JOptionPane.showMessageDialog(null, "PropertyID not exist");
                spinPropertyID.requestFocus();
                return;
            }
            //Image
            if (image == null) {
                JOptionPane.showMessageDialog(null, "Choose Image");
                return;
            }
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Add?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                copyImageIntoLandSoft();
                controller.ImagesController.addNewPropertyImage(propertyID, image);
                btnRefreshActionPerformed(evt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        try {
            String fileName = null;
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            chooser.setAcceptAllFileFilterUsed(true);
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedPicture = chooser.getSelectedFile();
                fileName = selectedPicture.getAbsolutePath();
                ImageIcon icon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
                lblImage.setIcon(icon);
            }
            if(result == JFileChooser.CANCEL_OPTION){
                return;
            }

            File img = new File(fileName);
            FileInputStream fis = new FileInputStream(img);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(b)) != -1) {
                bos.write(b);
            }
            image = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void txtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFindMouseClicked
        findPropertyImage();
    }//GEN-LAST:event_txtFindMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int imageID = Integer.parseInt(txtImageID.getText());
            int propertyID = Integer.parseInt(spinPropertyID.getValue().toString());
            if (!controller.TransactionsController.checkExistPropertyID(propertyID)) {
                JOptionPane.showMessageDialog(null, "PropertyID not exist");
                spinPropertyID.requestFocus();
                return;
            }
            //Image
            if (image == null) {
                JOptionPane.showMessageDialog(null, "Choose Image");
                return;
            }
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Update?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                copyImageIntoLandSoft();
                Images images = new Images(imageID, propertyID, image);
                controller.ImagesController.updatePropertyImage(images);
                btnRefreshActionPerformed(evt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int imageID = Integer.parseInt(txtImageID.getText());
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Delete?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                copyImageIntoLandSoft();
                controller.ImagesController.deletePropertyImage(imageID);
                btnRefreshActionPerformed(evt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JSpinner spinPropertyID;
    private javax.swing.JTable tblPropertyImage;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtImageID;
    // End of variables declaration//GEN-END:variables
}
