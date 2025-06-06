package UI;

import Entities.Proveedor;
import Entities.Articulo;
import Service.ProveedorService;

import javax.swing.*;
import java.util.List;
import UI.ArticuloProveedorForm;

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
                // Crear nuevo proveedor
                Proveedor nuevoProveedor = proveedorService.crearProveedor(nombre); // → ajustar si devuelve el proveedor creado
                JOptionPane.showMessageDialog(this, "Proveedor creado con éxito.");

                if (listadoPadre != null) listadoPadre.actualizarTabla();

                // Seleccionar artículo
                Articulo articuloSeleccionado = seleccionarArticulo();

                if (articuloSeleccionado != null) {
                    // Abrir formulario para ArticuloProveedor
                    new ArticuloProveedorForm(articuloSeleccionado, nuevoProveedor).setVisible(true);
                }

            } else {
                // Actualizar proveedor existente
                proveedorExistente.setNombreProveedor(nombre);
                proveedorService.actualizarProveedor(proveedorExistente);
                JOptionPane.showMessageDialog(this, "Proveedor actualizado con éxito.");

                if (listadoPadre != null) listadoPadre.actualizarTabla();
            }

            dispose();
        });

        JPanel panel = new JPanel();
        panel.add(jLabel1);
        panel.add(txtNombreProv);
        panel.add(jButton1);

        setContentPane(panel);
        pack();
    }

    private Articulo seleccionarArticulo() {
    List<Articulo> articulos = new Service.ArticuloService().obtenerTodos();
    if (articulos.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay artículos disponibles.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    Articulo seleccionado = (Articulo) JOptionPane.showInputDialog(
            this,
            "Seleccione un artículo:",
            "Asignar artículo",
            JOptionPane.QUESTION_MESSAGE,
            null,
            articulos.toArray(),
            articulos.get(0)
    );
    return seleccionado;
}
    private JLabel jLabel1;
    private JTextField txtNombreProv;
    private JButton jButton1;
}
