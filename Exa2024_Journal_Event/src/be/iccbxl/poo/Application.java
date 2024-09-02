package be.iccbxl.poo;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Application principale pour tester la sérialisation et la désérialisation des conférences.
 */
public class Application {
    public static void main(String[] args) {
        // Création des invités
        Guest bob = new Guest("Bob", "Sull", Arrays.asList(Topic.IT, Topic.ENVIRONMENT));
        Guest lydia = new Guest("Lydia", "Jenkins", Arrays.asList(Topic.ENERGY));

        // Création des conférences
        Conference conf1 = new Conference("Conférence low emission IT", LocalDateTime.parse("2024-09-02T18:00"), Topic.IT, 30);
        Conference conf2 = new Conference("Bavardages citoyens", LocalDateTime.parse("2024-09-06T20:00"));

        // Application des invités aux conférences
        try {
            conf1.apply(bob);
            conf2.apply(bob);
            conf1.apply(lydia);
        } catch (MissingTopicException e) {
            System.out.println("Erreur: " + e.getMessage());
        }

        // Affichage des conférences
        System.out.println(conf1);
        System.out.println(conf2);

        // Sauvegarde et chargement des conférences
        MyUtil.saveConfToFile(conf1, "conference1.xml");
        Conference loadedConf = MyUtil.loadConfFromFile("conference1.xml");

        // Afficher les détails après chargement
        System.out.println("Chargé depuis le fichier:");
        System.out.println(loadedConf);
    }
}
