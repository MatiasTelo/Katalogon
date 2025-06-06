package Service;

import DAO.ArticuloProveedorDAO;
import Entities.Articulo;
import Entities.ArticuloProveedor;
import Entities.Proveedor;

import java.util.List;

public class ArticuloProveedorService {

    private final ArticuloProveedorDAO articuloProveedorDAO;

    public ArticuloProveedorService() {
        this.articuloProveedorDAO = new ArticuloProveedorDAO();
    }

    public void guardarArticuloProveedor(ArticuloProveedor articuloProveedor) {
        articuloProveedorDAO.guardar(articuloProveedor);
    }

    public List<ArticuloProveedor> obtenerTodos() {
        return articuloProveedorDAO.listarTodosActivos();
    }

    public List<ArticuloProveedor> obtenerPorArticulo(Articulo articulo) {
        return articuloProveedorDAO.listarPorArticulo(articulo.getId());
    }

    public void eliminar(ArticuloProveedor articuloProveedor) {
        articuloProveedorDAO.eliminarLogicamente(articuloProveedor.getId());
    }

    public void crearArticuloProveedor(
        Proveedor proveedor, 
        Articulo articulo, 
        Integer demora_entrega, 
        float precio_unitario, 
        float costo_pedido
        ) throws Exception {

        try{

            ArticuloProveedor articuloProveedor = new ArticuloProveedor();

            if (demora_entrega == null) {
                throw new Exception("La demora de entrega no puede ser nula");
            } 

            if (precio_unitario == 0) {
                throw new Exception("El precio unitario no puede ser 0");
            }

            if (costo_pedido == 0) {
                throw new Exception("El costo de pedido no puede ser 0");
            }

            articuloProveedor.setDemoraEntrega(demora_entrega);
            articuloProveedor.setPrecioUnitario(precio_unitario);
            articuloProveedor.setCostoPedido(costo_pedido);

            articuloProveedor.setArticulo(articulo);
            articuloProveedor.setProveedor(proveedor);
            articuloProveedorDAO.guardar(articuloProveedor);

        } catch (Exception e) {
            System.out.println("Error al crear el articulo proveedor: " + e.getMessage());
        }

    }
}
