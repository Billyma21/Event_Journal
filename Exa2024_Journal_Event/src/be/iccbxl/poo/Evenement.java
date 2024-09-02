package be.iccbxl.poo;

import java.time.LocalDateTime;

public class Evenement {
    private String texte;
    private LocalDateTime dateEvent;

    // Constructor
    public Evenement(String texte, LocalDateTime dateEvent) {
        this.texte = texte;
        this.dateEvent = dateEvent;
    }

    // Getter for texte
    public String getTexte() {
        return texte;
    }

    // Getter for dateEvent
    public LocalDateTime getDateEvent() {
        return dateEvent;
    }

    // Setter for texte
    public void setTexte(String texte) {
        this.texte = texte;
    }

    // Setter for dateEvent
    public void setDateEvent(LocalDateTime dateEvent) {
        this.dateEvent = dateEvent;
    }

    @Override
    public String toString() {
        return texte + " on " + dateEvent.toString();
    }
}