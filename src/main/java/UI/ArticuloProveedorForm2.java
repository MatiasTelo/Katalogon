package UI;

import Entities.Articulo;
import Entities.ArticuloProveedor;
import Entities.Proveedor;
import Service.ArticuloProveedorService;
import Service.ProveedorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ArticuloProveedorForm2 extends JFrame {

    private final Articulo articulo;
    private final ArticuloProveedorService articuloProveedorService = new ArticuloProveedorService();
    private final ProveedorService proveedorService = new ProveedorService();

    private JComboBox<Proveedor> comboProveedores;
    private JTextField txtCostoPedido;
    private JTextField txtDemoraEntrega;
    private JTextField txtPrecioUnitario;
    private JButton btnGuardar;

    public ArticuloProveedorForm2(Articulo articulo) {
        this.articulo = articulo;
        initComponents();
    }

    private void initComponents() {
        setTitle("Agregar Proveedor a Artículo: " + articulo.getNombre());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        comboProveedores = new JComboBox<>();
        txtCostoPedido = new JTextField();
        txtDemoraEntrega = new JTextField();
        txtPrecioUnitario = new JTextField();
        btnGuardar = new JButton("Guardar");

        // Cargar proveedores en el combo
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        for (Proveedor proveedor : proveedores) {
            comboProveedores.addItem(proveedor);
        }

        add(new JLabel("Proveedor:"));
        add(comboProveedores);

        add(new JLabel("Costo de pedido:"));
        add(txtCostoPedido);

        add(new JLabel("Demora de entrega (días):"));
        add(txtDemoraEntrega);

        add(new JLabel("Precio unitario:"));
        add(txtPrecioUnitario);

        add(new JLabel("")); // vacío
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarArticuloProveedor();
            }
        });
    }

    private void guardarArticuloProveedor() {
        try {
            Proveedor proveedor = (Proveedor) comboProveedores.getSelectedItem();
            float costoPedido = Float.parseFloat(txtCostoPedido.getText());
            int demoraEntrega = Integer.parseInt(txtDemoraEntrega.getText());
            float precioUnitario = Float.parseFloat(txtPrecioUnitario.getText());

            ArticuloProveedor ap = new ArticuloProveedor();
            ap.setArticulo(articulo);
            ap.setProveedor(proveedor);
            ap.setCostoPedido(costoPedido);
            ap.setDemoraEntrega(demoraEntrega);
            ap.setPrecioUnitario(precioUnitario);

            articuloProveedorService.guardarArticuloProveedor(ap);
            JOptionPane.showMessageDialog(this, "Proveedor agregado al artículo exitosamente.");
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, completá todos los campos numéricos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}