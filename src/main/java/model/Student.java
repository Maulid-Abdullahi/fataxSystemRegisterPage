package model;
import BaseEntity.baseEntity;
import Contact.Contact;
import Person.Person;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "students")
@DynamicInsert
@DynamicUpdate
public class Student extends baseEntity {

    @Embedded
    private Person person;

    @Embedded
    private Contact contact;





    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private School School;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Commute Commute;

    public model.Commute getCommute() {
        return Commute;
    }

    public void setCommute(model.Commute commute) {
        Commute = commute;
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

    public model.School getSchool() {
        return School;
    }

    public void setSchool(model.School school) {
        School = school;
    }
}