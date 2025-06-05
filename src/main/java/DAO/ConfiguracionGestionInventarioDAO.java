package DAO;

import Entities.ConfiguracionGestionInventario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import java.util.List;

public class ConfiguracionGestionInventarioDAO {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tuUnidadPersistencia");
    EntityManager em = emf.createEntityManager();

    public void guardar(ConfiguracionGestionInventario config) {
        try {
            em.getTransaction().begin();
            em.persist(config);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<ConfiguracionGestionInventario> obtenerTodos() {
        
        try {
            TypedQuery<ConfiguracionGestionInventario> query = em.createQuery(
                    "SELECT c FROM ConfiguracionGestionInventario c", ConfiguracionGestionInventario.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<ConfiguracionGestionInventario> obtenerPorArticuloProveedorId(Long articuloProveedorId) {
        
        try {
            TypedQuery<ConfiguracionGestionInventario> query = em.createQuery(
                "SELECT c FROM ConfiguracionGestionInventario c WHERE c.articulo_proveedor.id = :id", 
                ConfiguracionGestionInventario.class);
            query.setParameter("id", articuloProveedorId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void eliminar(ConfiguracionGestionInventario config) {
        
        try {
            em.getTransaction().begin();
            ConfiguracionGestionInventario configRef = em.find(ConfiguracionGestionInventario.class, config.getId());
            if (configRef != null) {
                em.remove(configRef);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
