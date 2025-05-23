package it.esempio.biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String numeroTessera;

    // Getters e setters
    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
}