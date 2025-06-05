
package UI;

import Entities.Proveedor;
import Service.ProveedorService;
import java.util.List;

public class ArticuloFrom extends javax.swing.JFrame {

    private final ProveedorService proveedorService = new ProveedorService();
    public ArticuloFrom() {
        initComponents();
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        comboProveedores.removeAllItems(); // Limpia por si acaso
    
        for (Proveedor proveedor : proveedores) {
            comboProveedores.addItem(proveedor.getNombreProveedor()); // Agrega objetos Proveedor
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCostoMantArt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStockSeguridadArt = new javax.swing.JTextField();
        txtInvMaxArt = new javax.swing.JTextField();
        txtDemandaArt = new javax.swing.JTextField();
        txtStockInicialArt = new javax.swing.JTextField();
        txtCodArt = new javax.swing.JTextField();
        txtDescArt = new javax.swing.JTextField();
        comboProveedores = new javax.swing.JComboBox<>();
        siguientebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCostoMantArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoMantArtActionPerformed(evt);
            }
        });

        jLabel1.setText("CodArticulo");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Inventario Maximo");

        jLabel4.setText("Stock Inicial");

        jLabel5.setText("Stock de Seguridad");

        jLabel6.setText("Demanda");

        jLabel7.setText("Costo Mantenimiento");

        jLabel8.setText("Proveedor Predeterminado");

        txtStockSeguridadArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockSeguridadArtActionPerformed(evt);
            }
        });

        txtInvMaxArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInvMaxArtActionPerformed(evt);
            }
        });

        txtDemandaArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDemandaArtActionPerformed(evt);
            }
        });

        txtStockInicialArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockInicialArtActionPerformed(evt);
            }
        });

        txtCodArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodArtActionPerformed(evt);
            }
        });

        txtDescArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescArtActionPerformed(evt);
            }
        });

        comboProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        siguientebtn.setText("Siguiente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodArt)
                            .addComponent(txtDescArt)
                            .addComponent(txtInvMaxArt)
                            .addComponent(txtStockInicialArt)
                            .addComponent(txtStockSeguridadArt)
                            .addComponent(txtDemandaArt)
                            .addComponent(txtCostoMantArt)
                            .addComponent(comboProveedores, 0, 211, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(siguientebtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtInvMaxArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStockInicialArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStockSeguridadArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDemandaArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCostoMantArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(siguientebtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCostoMantArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoMantArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoMantArtActionPerformed

    private void txtStockSeguridadArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockSeguridadArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockSeguridadArtActionPerformed

    private void txtInvMaxArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInvMaxArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInvMaxArtActionPerformed

    private void txtDemandaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDemandaArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDemandaArtActionPerformed

    private void txtStockInicialArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockInicialArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockInicialArtActionPerformed

    private void txtCodArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodArtActionPerformed

    private void txtDescArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescArtActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArticuloFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton siguientebtn;
    private javax.swing.JTextField txtCodArt;
    private javax.swing.JTextField txtCostoMantArt;
    private javax.swing.JTextField txtDemandaArt;
    private javax.swing.JTextField txtDescArt;
    private javax.swing.JTextField txtInvMaxArt;
    private javax.swing.JTextField txtStockInicialArt;
    private javax.swing.JTextField txtStockSeguridadArt;
    // End of variables declaration//GEN-END:variables
}
