package DAO;

import Entities.Articulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ArticuloDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public void guardar(Articulo articulo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(articulo);
        em.getTransaction().commit();
        em.close();
    }

    public Articulo buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Articulo a = em.find(Articulo.class, id);
        em.close();
        return a;
    }

    public List<Articulo> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Articulo> lista = em.createQuery("SELECT a FROM Articulo a", Articulo.class).getResultList();
        em.close();
        return lista;
    }

    public void actualizar(Articulo articulo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(articulo);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        Articulo articulo = em.find(Articulo.class, id);
        if (articulo != null) {
            em.getTransaction().begin();
            em.remove(articulo);
            em.getTransaction().commit();
        }
        em.close();
    }
}
