package UI;

import Entities.Proveedor;
import Service.ProveedorService;

import javax.swing.*;

public class ProveedorForm extends JFrame {
    private final ProveedorService proveedorService = new ProveedorService();
    private Proveedor proveedorExistente;
    private ListadoProveedores listadoPadre;

    public ProveedorForm(Proveedor proveedor, ListadoProveedores listado) {
        this.proveedorExistente = proveedor;
        this.listadoPadre = listado;

        initComponents();

        if (proveedorExistente != null) {
            txtNombreProv.setText(proveedorExistente.getNombreProveedor());
            jButton1.setText("Actualizar");
        }
    }

    private void initComponents() {
        jLabel1 = new JLabel("Nombre:");
        txtNombreProv = new JTextField(20);
        jButton1 = new JButton("Crear");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Formulario Proveedor");
        setSize(300, 150);
        setLocationRelativeTo(null);

        jButton1.addActionListener(e -> {
            String nombre = txtNombreProv.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (proveedorExistente == null) {
                proveedorService.crearProveedor(nombre);
                JOptionPane.showMessageDialog(this, "Proveedor creado con éxito.");
            } else {
                proveedorExistente.setNombreProveedor(nombre);
                proveedorService.actualizarProveedor(proveedorExistente);
                JOptionPane.showMessageDialog(this, "Proveedor actualizado con éxito.");
            }

            if (listadoPadre != null) listadoPadre.actualizarTabla();
            dispose();
        });

        JPanel panel = new JPanel();
        panel.add(jLabel1);
        panel.add(txtNombreProv);
        panel.add(jButton1);

        setContentPane(panel);
        pack();
    }

    private JLabel jLabel1;
    private JTextField txtNombreProv;
    private JButton jButton1;
}
