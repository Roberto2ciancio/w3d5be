package it.esempio.biblioteca.dao;

import it.esempio.biblioteca.model.*;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ElementoCatalogoDAO {
    private final EntityManager em;

    public ElementoCatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void salva(ElementoCatalogo elemento) {
        em.getTransaction().begin();
        em.persist(elemento);
        em.getTransaction().commit();
    }

    public void rimuovi(String isbn) {
        em.getTransaction().begin();
        ElementoCatalogo trovato = em.find(ElementoCatalogo.class, isbn);
        if (trovato != null) em.remove(trovato);
        em.getTransaction().commit();
    }

    public ElementoCatalogo cercaPerISBN(String isbn) {
        return em.find(ElementoCatalogo.class, isbn);
    }

    public List<ElementoCatalogo> cercaPerAnno(int anno) {
        return em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno", ElementoCatalogo.class)
                .setParameter("anno", anno)
                .getResultList();
    }

    public List<Libro> cercaPerAutore(String autore) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autore LIKE :autore", Libro.class)
                .setParameter("autore", "%" + autore + "%")
                .getResultList();
    }

    public List<ElementoCatalogo> cercaPerTitolo(String titolo) {
        return em.createQuery("SELECT e FROM ElementoCatalogo e WHERE LOWER(e.titolo) LIKE LOWER(:titolo)", ElementoCatalogo.class)
                .setParameter("titolo", "%" + titolo + "%")
                .getResultList();
    }
}