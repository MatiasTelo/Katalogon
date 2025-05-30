package UI;

import Entities.Proveedor;
import Service.ProveedorService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListadoProveedores extends javax.swing.JFrame {
    private final ProveedorService proveedorService = new ProveedorService();

    public ListadoProveedores() {
        initComponents();
        cargarProveedores();
    }

    private void cargarProveedores() {
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        DefaultTableModel model = (DefaultTableModel) tablaProveedores.getModel();
        model.setRowCount(0); // limpiar tabla
        for (Proveedor p : proveedores) {
            model.addRow(new Object[]{p.getId(), p.getNombreProveedor()});
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        tablaProveedores = new JTable();
        btnCrear = new JButton("Crear");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Proveedores");
        setSize(800, 600);

        tablaProveedores.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jScrollPane1.setViewportView(tablaProveedores);

        btnCrear.addActionListener(e -> {
            new ProveedorForm(null, this).setVisible(true);
        });

        btnModificar.addActionListener(e -> {
            int selectedRow = tablaProveedores.getSelectedRow();
            if (selectedRow != -1) {
                Long id = (Long) tablaProveedores.getValueAt(selectedRow, 0);
                Proveedor proveedor = proveedorService.obtenerProveedor(id);
                new ProveedorForm(proveedor, this).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un proveedor para modificar.");
            }
        });

        btnEliminar.addActionListener(e -> {
            int selectedRow = tablaProveedores.getSelectedRow();
            if (selectedRow != -1) {
                Long id = (Long) tablaProveedores.getValueAt(selectedRow, 0);
                int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    proveedorService.eliminarProveedor(id);
                    cargarProveedores();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un proveedor para eliminar.");
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnCrear)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCrear)
                                .addComponent(btnModificar)
                                .addComponent(btnEliminar))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addContainerGap())
        );

        pack();
    }

    public void actualizarTabla() {
        cargarProveedores();
    }

    private JScrollPane jScrollPane1;
    private JTable tablaProveedores;
    private JButton btnCrear, btnModificar, btnEliminar;
}
