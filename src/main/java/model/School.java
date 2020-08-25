package model;

import BaseEntity.baseEntity;
import Contact.Contact;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schools")
public class School extends baseEntity {

    private String name;

    public School() {
    }

    @Embedded
    private Contact contact;
    @Column
   private String Student;
    @Column
    private String commute;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getStudent() {
        return Student;
    }

    public void setStudent(String student) {
        Student = student;
    }

    public String getCommute() {
        return commute;
    }

    public void setCommute(String commute) {
        this.commute = commute;
    }

}