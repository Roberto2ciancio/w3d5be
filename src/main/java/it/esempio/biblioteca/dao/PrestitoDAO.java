
package it.esempio.biblioteca.dao;

import it.esempio.biblioteca.model.Prestito;

import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void salva(Prestito prestito) {
        em.getTransaction().begin();
        em.persist(prestito);
        em.getTransaction().commit();
    }

    public List<Prestito> prestitiAttiviPerUtente(String numeroTessera) {
        return em.createQuery(
                        "SELECT p FROM Prestito p " +
                                "WHERE p.utente.numeroTessera = :tessera " +
                                "AND p.dataRestituzioneEffettiva IS NULL",
                        Prestito.class)
                .setParameter("tessera", numeroTessera)
                .getResultList();
    }

    public List<Prestito> prestitiScaduti() {
        return em.createQuery(
                        "SELECT p FROM Prestito p " +
                                "WHERE p.dataRestituzioneEffettiva IS NULL " +
                                "AND p.dataRestituzionePrevista < :oggi",
                        Prestito.class)
                .setParameter("oggi", LocalDate.now())
                .getResultList();
    }
}
