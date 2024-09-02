package be.iccbxl.poo;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ConferenceTest {

    @Test
    public void testConferenceConstructor() {
        Conference conf = new Conference("Conférence low emission IT", LocalDateTime.of(2024, 9, 2, 18, 0), Topic.IT, 30.0);
        assertEquals("Conférence low emission IT", conf.getTexte());
        assertEquals(LocalDateTime.of(2024, 9, 2, 18, 0), conf.getDateEvent());
        assertEquals(Topic.IT, conf.getTopic());
        assertEquals(30.0, conf.getPrice());
        assertTrue(conf.getGuests().isEmpty());
    }

    @Test
    public void testApplyGuestWithMatchingTopic() {
        Guest guest = new Guest("Bob", "Sull", Arrays.asList(Topic.IT, Topic.ENVIRONMENT));
        Conference conf = new Conference("Conférence IT", LocalDateTime.of(2024, 9, 2, 18, 0), Topic.IT, 30.0);
        assertTrue(conf.apply(guest));
        assertEquals(1, conf.getGuests().size());
        assertEquals(guest, conf.getGuests().get(0));
    }

    @Test
    public void testApplyGuestWithoutMatchingTopic() {
        Guest guest = new Guest("Alice", "Doe", Arrays.asList(Topic.ENVIRONMENT));
        Conference conf = new Conference("Conférence IT", LocalDateTime.of(2024, 9, 2, 18, 0), Topic.IT, 30.0);
        assertThrows(MissingTopicException.class, () -> conf.apply(guest));
        assertTrue(conf.getGuests().isEmpty());
    }

    @Test
    public void testToString() {
        Guest guest1 = new Guest("Bob", "Sull", Arrays.asList(Topic.IT, Topic.ENVIRONMENT));
        Guest guest2 = new Guest("Lydia", "Jenkins", Arrays.asList(Topic.ENVIRONMENT));
        Conference conf = new Conference("Bavardages citoyens", LocalDateTime.of(2024, 9, 6, 20, 0));
        conf.apply(guest1);
        conf.apply(guest2);

        String expected = "Bavardages citoyens – 2024-09-06T20:00 – Gratuit / Thème libre\n" +
                          "- Bob SULL\n" +
                          "- Lydia JENKINS\n";
        assertEquals(expected, conf.toString());
    }
}