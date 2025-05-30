package Service;

import DAO.ProveedorDAO;
import Entities.Proveedor;

import java.util.List;

public class ProveedorService {
    private final ProveedorDAO proveedorDAO = new ProveedorDAO();

    public void crearProveedor(String nombre) {
        Proveedor proveedor = Proveedor.builder()
                .nombreProveedor(nombre)
                .build();
        proveedorDAO.guardar(proveedor);
    }

    public void actualizarProveedor(Proveedor proveedor) {
        proveedorDAO.actualizar(proveedor);
    }

    public void eliminarProveedor(Long id) {
        proveedorDAO.baja(id);
    }

    public Proveedor obtenerProveedor(Long id) {
        return proveedorDAO.buscarPorId(id);
    }

    public List<Proveedor> listarProveedores() {
        return proveedorDAO.listarTodos();
    }
}
