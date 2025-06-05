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
}
