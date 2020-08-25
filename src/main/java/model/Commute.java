package model;
import BaseEntity.baseEntity;
import Contact.Contact;
import Person.Person;
import javax.persistence.*;

@Entity
@Table(name = "commutes")
public class Commute extends baseEntity {
    @Embedded
    private Person person;

    @Embedded
    private Contact contact;

    @Column
    private String school;

    @Column
    private String student;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private School School;

    public Commute() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(model.School school) {
        School = school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
}
