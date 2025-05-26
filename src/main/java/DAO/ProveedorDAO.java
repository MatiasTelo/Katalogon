package DAO;

import Entities.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;

import java.util.List;

public class ProveedorDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tuUnidadPersistencia");

    public void guardar(Proveedor proveedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(proveedor);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizar(Proveedor proveedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(proveedor);
        em.getTransaction().commit();
        em.close();
    }

    public void baja(Long id) {
        EntityManager em = emf.createEntityManager();
        Proveedor proveedor = em.find(Proveedor.class, id);
        if (proveedor != null) {
            em.getTransaction().begin();
            proveedor.setFechaHoraBaja(LocalDateTime.now());
            em.getTransaction().commit();
        }
        em.close();
    }

    public Proveedor buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Proveedor proveedor = em.find(Proveedor.class, id);
        em.close();
        return proveedor;
    }

    public List<Proveedor> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Proveedor> lista = em.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();
        em.close();
        return lista;
    }
}
