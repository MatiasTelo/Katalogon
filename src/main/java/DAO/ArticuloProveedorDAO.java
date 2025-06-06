package DAO;

import Entities.ArticuloProveedor;
import Entities.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.time.LocalDateTime;


public class ArticuloProveedorDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tuUnidadPersistencia");
    EntityManager em = emf.createEntityManager();

    public ArticuloProveedorDAO() {
    }

    public void guardar(ArticuloProveedor ap) {
        em.getTransaction().begin();
        em.persist(ap);
        em.getTransaction().commit();
    }

    public void actualizar(ArticuloProveedor ap) {
        em.getTransaction().begin();
        em.merge(ap);
        em.getTransaction().commit();
    }

    public void eliminarLogicamente(Long id) {
        ArticuloProveedor ap = em.find(ArticuloProveedor.class, id);
        if (ap != null) {
            em.getTransaction().begin();
            ap.setFechaHoraBaja(LocalDateTime.now());
            em.getTransaction().commit();
        }
    }

    public ArticuloProveedor buscarPorId(Long id) {
        return em.find(ArticuloProveedor.class, id);
    }

    public List<ArticuloProveedor> listarTodosActivos() {
        return em.createQuery("""
                SELECT ap FROM ArticuloProveedor ap
                WHERE ap.fechaHoraBaja IS NULL
            """, ArticuloProveedor.class)
            .getResultList();
    }

    public List<ArticuloProveedor> listarPorArticulo(Long articuloId) {
        return em.createQuery("""
                SELECT ap FROM ArticuloProveedor ap
                WHERE ap.articulo.id = :articuloId AND ap.fechaHoraBaja IS NULL
            """, ArticuloProveedor.class)
            .setParameter("articuloId", articuloId)
            .getResultList();
    }

    public List<ArticuloProveedor> listarPorProveedor(Proveedor proveedor) {
        return em.createQuery("""
                SELECT ap FROM ArticuloProveedor ap
                WHERE ap.proveedor = :proveedor AND ap.fechaHoraBaja IS NULL
            """, ArticuloProveedor.class)
            .setParameter("proveedor", proveedor)
            .getResultList();
    }

    public List<ArticuloProveedor> listarPorProveedorPredeterminado(Proveedor proveedor) {
        return em.createQuery("""
                SELECT ap FROM ArticuloProveedor ap
                WHERE ap.proveedor = :proveedor AND ap.fechaHoraBaja IS NULL AND ap.esPredeterminado = true
            """, ArticuloProveedor.class)
            .setParameter("proveedor", proveedor)
            .getResultList();
    }

}
