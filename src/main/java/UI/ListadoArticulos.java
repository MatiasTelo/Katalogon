package UI;

import Entities.Articulo;
import Service.ArticuloService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ListadoArticulos extends javax.swing.JFrame {

    private ArticuloService articuloService = new ArticuloService();
    private JTable tablaArticulos;
    private DefaultTableModel modeloTabla;

    public ListadoArticulos() {
        initComponents();
        configurarTabla();
        cargarArticulos();

        crearArticulobtn.addActionListener(evt -> {
            ArticuloFrom articuloForm = new ArticuloFrom();
            articuloForm.setVisible(true);
        });
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Descripción", "Acción"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No editable
            }
        };

        tablaArticulos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaArticulos);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(scrollPane, java.awt.BorderLayout.CENTER);

        tablaArticulos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int row = tablaArticulos.rowAtPoint(evt.getPoint());
                int col = tablaArticulos.columnAtPoint(evt.getPoint());

                if (col == 3) { // Columna "Acción"
                    Long idArticulo = (Long) tablaArticulos.getValueAt(row, 0);
                    Articulo articulo = articuloService.obtenerPorId(idArticulo);
                    ArticuloProveedorForm form = new ArticuloProveedorForm(articulo);
                    form.setVisible(true);
                }
            }
        });
    }

    private void cargarArticulos() {
        modeloTabla.setRowCount(0); // Limpia tabla
        List<Articulo> articulos = articuloService.obtenerTodos();

        for (Articulo art : articulos) {
            modeloTabla.addRow(new Object[]{
                    art.getId(),
                    art.getNombre(),
                    art.getDescripcionArticulo(),
                    "Agregar proveedor"
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        crearArticulobtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        crearArticulobtn.setText("Crear articulo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crearArticulobtn)
                .addContainerGap(1413, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(crearArticulobtn)
                .addGap(0, 275, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ListadoArticulos().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton crearArticulobtn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
