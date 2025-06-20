package UI;

import Entities.Articulo;
import Entities.ArticuloProveedor;
import Entities.Proveedor;
import Service.ArticuloProveedorService;

import javax.swing.*;
import java.awt.*;

public class ArticuloProveedorForm extends JFrame {

    private final Articulo articulo;
    private final Proveedor proveedor;
    private final ArticuloProveedorService articuloProveedorService = new ArticuloProveedorService();

    private JTextField txtCostoPedido;
    private JTextField txtDemoraEntrega;
    private JTextField txtPrecioUnitario;
    private JButton btnGuardar;

    public ArticuloProveedorForm(Articulo articulo, Proveedor proveedor) {
        this.articulo = articulo;
        this.proveedor = proveedor;
        initComponents();
    }

    private void initComponents() {
        setTitle("Agregar Proveedor al Artículo: " + articulo.getNombre());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        txtCostoPedido = new JTextField();
        txtDemoraEntrega = new JTextField();
        txtPrecioUnitario = new JTextField();
        btnGuardar = new JButton("Guardar");

        // Agregar campos al formulario
        add(new JLabel("Proveedor:"));
        add(new JLabel(proveedor.getNombreProveedor()));  // mostrar nombre del proveedor

        add(new JLabel("Costo de pedido:"));
        add(txtCostoPedido);

        add(new JLabel("Demora de entrega (días):"));
        add(txtDemoraEntrega);

        add(new JLabel("Precio unitario:"));
        add(txtPrecioUnitario);

        add(new JLabel("")); // espacio vacío
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardarArticuloProveedor());
    }

    private void guardarArticuloProveedor() {
        try {
            float costoPedido = Float.parseFloat(txtCostoPedido.getText());
            int demoraEntrega = Integer.parseInt(txtDemoraEntrega.getText());
            float precioUnitario = Float.parseFloat(txtPrecioUnitario.getText());

            if (costoPedido <= 0 || precioUnitario <= 0 || demoraEntrega <= 0) {
                throw new IllegalArgumentException("Todos los valores deben ser mayores a 0.");
            }

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
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
