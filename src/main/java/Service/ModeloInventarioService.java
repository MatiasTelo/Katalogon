package Service;

import DAO.ModeloInventarioDAO;
import Entities.ModeloInventario;

public class ModeloInventarioService {

    private final ModeloInventarioDAO dao;

    public ModeloInventarioService() {
        this.dao = new ModeloInventarioDAO();
    }

    public void guardarModeloInventario(ModeloInventario modelo) {
        dao.guardar(modelo);
    }

    public void cerrar() {
        dao.cerrar();
    }
}
