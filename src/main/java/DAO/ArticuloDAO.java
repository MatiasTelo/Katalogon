package DAO;

import Entities.Articulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ArticuloDAO {
    private EntityManager em;

    public ArticuloDAO(EntityManager em) {
        this.em = em;
    }

    public Articulo buscarPorId(Long id) {
        return em.find(Articulo.class, id);
    }

    public void guardar(Articulo articulo) {
        em.getTransaction().begin();
        em.persist(articulo);
        em.getTransaction().commit();
    }

    public void actualizar(Articulo articulo) {
        em.getTransaction().begin();
        em.merge(articulo);
        em.getTransaction().commit();
    }

    public List<Articulo> listarTodos() {
        return em.createQuery("SELECT a FROM Articulo a", Articulo.class).getResultList();
    }

    // Artículos a reponer: stockActual <= puntoPedido
    public List<Articulo> listarProductosAReponer() {
        String jpql = """
            SELECT a FROM Articulo a 
            JOIN ConfiguracionGestionInventario cgi ON cgi.articulo = a
            WHERE a.stockActual <= cgi.puntoPedido
            AND cgi.fechaHoraBajaConfiguracion IS NULL
        """;
        TypedQuery<Articulo> query = em.createQuery(jpql, Articulo.class);
        return query.getResultList();
    }

    // Artículos faltantes: stockActual <= stockSeguridad
    public List<Articulo> listarProductosFaltantes() {
        return em.createQuery(
            "SELECT a FROM Articulo a WHERE a.stockActual <= a.stockSeguridad",
            Articulo.class
        ).getResultList();
    }
}
