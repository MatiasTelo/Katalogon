package UI;

import Entities.ModeloInventario;
import Service.ModeloInventarioService;

import javax.swing.*;
import java.awt.*;

public class ModeloInventarioForm extends JFrame {

    private final JTextField txtNombreMetodo;
    private final JButton btnGuardar;

    private final ModeloInventarioService service = new ModeloInventarioService();

    public ModeloInventarioForm() {
        setTitle("Crear Modelo de Inventario");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        txtNombreMetodo = new JTextField();
        btnGuardar = new JButton("Guardar");

        add(new JLabel("Nombre del metodo:"));
        add(txtNombreMetodo);
        add(new JLabel());
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardarModelo());
    }

    private void guardarModelo() {
        try {
            String metodo = txtNombreMetodo.getText();
            if (metodo == null) {
                throw new IllegalArgumentException("Completa el nombre");
            }

            ModeloInventario modelo = ModeloInventario.builder()
                    .nombreMetodo(metodo)
                    .build();

            service.guardarModeloInventario(modelo);
            JOptionPane.showMessageDialog(this, "Modelo de inventario guardado correctamente.");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
