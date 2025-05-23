package it.esempio.biblioteca.dao;

import it.esempio.biblioteca.model.Utente;  // <- questo manca

import jakarta.persistence.EntityManager;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void salva(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
    }

    public Utente cercaPerNumeroTessera(String numeroTessera) {
        return em.createQuery("SELECT u FROM Utente u WHERE u.numeroTessera = :tessera", Utente.class)
                .setParameter("tessera", numeroTessera)
                .getSingleResult();
    }
}
