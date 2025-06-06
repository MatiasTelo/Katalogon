package UI;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                  
    private void initComponents() {

        btnArticulos = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnModelosInventario = new javax.swing.JButton();

        btnModelosInventario.setText("Modelos de Inventario");
        btnModelosInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelosInventarioActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));

        btnArticulos.setText("Artículos");
        btnArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosActionPerformed(evt);
            }
        });

        btnProveedores.setText("Proveedores");
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModelosInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(881, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnArticulos)
                .addGap(26, 26, 26)
                .addComponent(btnProveedores)
                .addGap(26, 26, 26)
                .addComponent(btnModelosInventario)
                .addContainerGap(450, Short.MAX_VALUE))
        );

        pack();
    }
                     

    // Acción del botón Artículos
    private void btnArticulosActionPerformed(java.awt.event.ActionEvent evt) {
        new ListadoArticulos().setVisible(true);
        this.dispose();
    }

    // Acción del botón Proveedores
    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {
        new ListadoProveedores().setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainMenu().setVisible(true));
    }
    private void btnModelosInventarioActionPerformed(java.awt.event.ActionEvent evt) {
    new ModeloInventarioForm().setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnArticulos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnModelosInventario;

    // End of variables declaration                   
}
