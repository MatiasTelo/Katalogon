package Service;

import DAO.ArticuloDAO;
import Entities.Articulo;

import java.util.List;

public class ArticuloService {

    private final ArticuloDAO articuloDAO;

    public ArticuloService() {
        this.articuloDAO = new ArticuloDAO();
    }

    public void guardarArticulo(Articulo articulo) {
        articuloDAO.guardar(articulo);
    }

    public Articulo obtenerPorId(Long id) {
        return articuloDAO.buscarPorId(id);
    }

    public List<Articulo> obtenerTodos() {
        return articuloDAO.listarTodos();
    }

    public void eliminarArticulo(Articulo articulo) {
        articuloDAO.bajaArticulo(articulo.getId());
    }

    public void actualizarArticulo(Articulo articulo) {
        articuloDAO.actualizar(articulo);
    }
}
