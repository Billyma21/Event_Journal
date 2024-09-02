package be.iccbxl.poo;

import java.util.List;

public class Guest {
    private String firstname;
    private String lastname;
    private List<Topic> topics;

    public Guest(String firstname, String lastname, List<Topic> topics) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.topics = topics;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname.toUpperCase();
    }
}
