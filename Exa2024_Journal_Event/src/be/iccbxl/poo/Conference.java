package be.iccbxl.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une conférence avec un thème, un prix, et une liste d'invités.
 * Les conférences peuvent avoir un thème requis pour l'inscription des invités.
 * 
 * @autor Maayoud Bilal
 */
public class Conference extends Evenement implements Applicable {

    private Topic topic; // Thème de la conférence
    private double price; // Prix de la conférence
    private List<Guest> guests; // Liste des invités

    /**
     * Constructeur pour une conférence avec un thème et un prix.
     *
     * @param texte     Le titre de la conférence.
     * @param dateEvent La date et l'heure de l'événement.
     * @param topic     Le thème de la conférence.
     * @param price     Le prix de la conférence.
     */
    public Conference(String texte, LocalDateTime dateEvent, Topic topic, double price) {
        super(texte, dateEvent);
        this.topic = topic;
        this.price = price;
        this.guests = new ArrayList<>();
    }

    /**
     * Constructeur pour une conférence sans thème et gratuite.
     *
     * @param texte     Le titre de la conférence.
     * @param dateEvent La date et l'heure de l'événement.
     */
    public Conference(String texte, LocalDateTime dateEvent) {
        super(texte, dateEvent);
        this.topic = null; // Pas de thème requis
        this.price = 0; // Gratuit par défaut
        this.guests = new ArrayList<>();
    }

    /**
     * Retourne le thème de la conférence.
     *
     * @return Le thème de la conférence.
     */
    public Topic getTopic() {
        return topic;
    }

    /**
     * Définit le thème de la conférence.
     *
     * @param topic Le thème à définir.
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    /**
     * Retourne le prix de la conférence.
     *
     * @return Le prix de la conférence.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Définit le prix de la conférence.
     *
     * @param price Le prix à définir.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retourne la liste des invités de la conférence.
     *
     * @return La liste des invités.
     */
    public List<Guest> getGuests() {
        return new ArrayList<>(guests); // Retourne une copie pour éviter les modifications externes
    }

    /**
     * Ajoute un invité à la conférence.
     * 
     * @param guest L'invité à ajouter.
     * @return true si l'invité a été ajouté avec succès, sinon false.
     * @throws MissingTopicException Si l'invité n'a pas le thème requis pour cette conférence.
     */
    @Override
    public boolean apply(Guest guest) throws MissingTopicException {
        if (this.topic != null && !guest.getTopics().contains(this.topic)) {
            throw new MissingTopicException("L'invité n'a pas le thème requis pour cette conférence.");
        }
        return this.guests.add(guest);
    }

    /**
     * Retourne une représentation textuelle de la conférence.
     *
     * @return La chaîne de caractères représentant la conférence.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getTexte())
          .append(" – ")
          .append(super.getDateEvent())
          .append(" – ")
          .append(price == 0 ? "Gratuit" : price + "€")
          .append(" / ")
          .append(topic == null ? "Thème libre" : topic)
          .append("\n");

        for (Guest guest : guests) {
            sb.append("- ").append(guest.toString()).append("\n");
        }
        return sb.toString();
    }
}
