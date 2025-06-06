package DAO;

import Entities.ModeloInventario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ModeloInventarioDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tuUnidadPersistencia");
    private final EntityManager em = emf.createEntityManager();

    public ModeloInventarioDAO() {
    }

    public ModeloInventario buscarPorId(Long id) {
        return em.find(ModeloInventario.class, id);
    }

    public void guardar(ModeloInventario modelo) {
        em.getTransaction().begin();
        em.persist(modelo);
        em.getTransaction().commit();
    }

    public void actualizar(ModeloInventario modelo) {
        em.getTransaction().begin();
        em.merge(modelo);
        em.getTransaction().commit();
    }

    public List<ModeloInventario> listarTodos() {
        return em.createQuery("SELECT m FROM ModeloInventario m", ModeloInventario.class).getResultList();
    }

    // Método adicional (opcional) para eliminar
    public void eliminar(Long id) {
        ModeloInventario modelo = em.find(ModeloInventario.class, id);
        if (modelo != null) {
            em.getTransaction().begin();
            em.remove(modelo);
            em.getTransaction().commit();
        }
    }

    // Cierra el EntityManager y el EntityManagerFactory (si deseas)
    public void cerrar() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }
}
