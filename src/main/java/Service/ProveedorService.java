package Service;

import DAO.ProveedorDAO;
import DAO.ArticuloProveedorDAO;
import Entities.Proveedor;
import Entities.ArticuloProveedor;
import java.time.LocalDateTime;

import java.util.List;

public class ProveedorService {
    private final ProveedorDAO proveedorDAO = new ProveedorDAO();
    private final ArticuloProveedorDAO articuloProveedorDAO = new ArticuloProveedorDAO();

    public Proveedor crearProveedor(String nombre) {
        Proveedor proveedor = Proveedor.builder()
                .nombreProveedor(nombre)
                .build();
        proveedorDAO.guardar(proveedor);
        return proveedor;
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

    public void darDeBajaProveedor(Long id) throws Exception{

        try{
            Proveedor proveedor = proveedorDAO.buscarPorId(id);

            List<ArticuloProveedor> articuloProveedorList = articuloProveedorDAO.listarPorProveedorPredeterminado(proveedor);

            if (!articuloProveedorList.isEmpty()) {
                throw new Exception("El proveedor tiene articulos predeterminados");
            }

            proveedorDAO.baja(id);

            System.out.println("Proveedor " + proveedor.getNombreProveedor()+ " dado de baja");

        } catch (Exception e){
            System.out.println("No se pudo dar de baja el proveedor: " + e.getMessage());
        }
    }

}
