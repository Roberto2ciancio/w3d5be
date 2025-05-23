package it.esempio.biblioteca.service;

import it.esempio.biblioteca.dao.*;
import it.esempio.biblioteca.model.*;

import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class BibliotecaService {
    private final ElementoCatalogoDAO elementoDAO;
    private final UtenteDAO utenteDAO;
    private final PrestitoDAO prestitoDAO;

    public BibliotecaService(EntityManager em) {
        this.elementoDAO = new ElementoCatalogoDAO(em);
        this.utenteDAO = new UtenteDAO(em);
        this.prestitoDAO = new PrestitoDAO(em);
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        elementoDAO.salva(elemento);
    }

    public void rimuoviElemento(String isbn) {
        elementoDAO.rimuovi(isbn);
    }

    public List<ElementoCatalogo> ricercaPerTitolo(String titolo) {
        return elementoDAO.cercaPerTitolo(titolo);
    }

    public void registraPrestito(Utente utente, ElementoCatalogo elemento) {
        Prestito prestito = new Prestito();
        prestito.setUtente(utente);
        prestito.setElementoPrestato(elemento);
        prestito.setDataInizioPrestito(LocalDate.now());
        prestitoDAO.salva(prestito);
    }

    public List<Prestito> visualizzaPrestitiAttivi(String numeroTessera) {
        return prestitoDAO.prestitiAttiviPerUtente(numeroTessera);
    }

    public List<Prestito> visualizzaPrestitiScaduti() {
        return prestitoDAO.prestitiScaduti();
    }

    public void registraUtente(Utente utente) {
        utenteDAO.salva(utente);
    }
}