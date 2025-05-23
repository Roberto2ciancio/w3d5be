package it.esempio.biblioteca.model;

import it.esempio.biblioteca.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class TestBiblioteca {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
        EntityManager em = emf.createEntityManager();

        Libro libro = new Libro();
        libro.setIsbn("1234567890");
        libro.setTitolo("Il Signore degli Anelli");
        libro.setAnnoPubblicazione(1954);
        libro.setNumeroPagine(1200);
        libro.setAutore("J.R.R. Tolkien");
        libro.setGenere("Fantasy");

        Utente utente = new Utente();
        utente.setNumeroTessera("T12345");
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setDataNascita(LocalDate.of(1990, 1, 1));

        Prestito prestito = new Prestito();
        prestito.setUtente(utente);
        prestito.setElementoPrestato(libro);
        prestito.setDataInizioPrestito(LocalDate.now());
        prestito.setDataRestituzionePrevista(LocalDate.now().plusDays(30));

        em.getTransaction().begin();
        em.persist(libro);
        em.persist(utente);
        em.persist(prestito);
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Inserimento completato con successo.");
    }
}
