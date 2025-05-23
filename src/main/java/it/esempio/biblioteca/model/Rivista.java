package it.esempio.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Rivista extends ElementoCatalogo {
    public enum Periodicita { SETTIMANALE, MENSILE, SEMESTRALE }

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    // Getters e setters
}