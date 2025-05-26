
package Service;

import Entities.Articulo;
import Entities.ArticuloProveedor;
import Entities.ConfiguracionGestionInventario;
import DAO.ArticuloDAO;
import DAO.ArticuloProveedorDAO;
import DAO.ConfiguracionGestionInventarioDAO;

import java.time.LocalDateTime;
import java.util.List;

public class ArticuloService {

    private final ArticuloDAO articuloDAO;
    private final ArticuloProveedorDAO articuloProveedorDAO;
    private final ConfiguracionGestionInventarioDAO configDAO;

    public ArticuloService(ArticuloDAO articuloDAO, ArticuloProveedorDAO articuloProveedorDAO, ConfiguracionGestionInventarioDAO configDAO) {
        this.articuloDAO = articuloDAO;
        this.articuloProveedorDAO = articuloProveedorDAO;
        this.configDAO = configDAO;
    }

    public void calcularModeloLoteFijo(Long articuloId) {
        
    }

    public List<Articulo> obtenerProductosAReponer() {
        return articuloDAO.listarProductosAReponer();
    }

    public List<Articulo> obtenerProductosFaltantes() {
        return articuloDAO.listarProductosFaltantes();
    }

}