package be.iccbxl.poo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.security.ExplicitTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utilitaire pour la sérialisation et la désérialisation des conférences en XML.
 */
public class MyUtil {

    private static final Class<?>[] ALLOWED_CLASSES = {
        Conference.class,
        Guest.class,
        Topic.class
    };

    private static XStream createXStream() {
        XStream xstream = new XStream(new StaxDriver());

        // Configurer les alias pour les classes
        xstream.alias("Conf", Conference.class);
        xstream.alias("guest", Guest.class);
        xstream.alias("topic", Topic.class);

        // Définir les attributs pour la classe Conference
        xstream.useAttributeFor(Conference.class, "topic");
        xstream.useAttributeFor(Conference.class, "price");
        xstream.useAttributeFor(Conference.class, "dateEvent");

        // Configurer les éléments pour la classe Guest
        xstream.aliasField("firstname", Guest.class, "firstname");
        xstream.aliasField("lastname", Guest.class, "lastname");
        xstream.addImplicitCollection(Guest.class, "topics", "skill", Topic.class);

        // Configurer les permissions de sécurité
        xstream.addPermission(new ExplicitTypePermission(ALLOWED_CLASSES));
        xstream.addPermission(NoTypePermission.NONE);

        return xstream;
    }

    /**
     * Sauvegarde une conférence dans un fichier XML.
     *
     * @param conf     La conférence à sauvegarder.
     * @param filename Le nom du fichier XML.
     */
    public static void saveConfToFile(Conference conf, String filename) {
        XStream xstream = createXStream();

        // Créer le répertoire si nécessaire
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileWriter writer = new FileWriter(new File(directory, filename))) {
            // Convertir l'objet en XML avec une sortie formatée
            xstream.marshal(conf, new PrettyPrintWriter(writer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Charge une conférence depuis un fichier XML.
     *
     * @param filename Le nom du fichier XML.
     * @return La conférence chargée.
     */
    public static Conference loadConfFromFile(String filename) {
        XStream xstream = createXStream();

        try (FileReader reader = new FileReader(new File("data", filename))) {
            return (Conference) xstream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
