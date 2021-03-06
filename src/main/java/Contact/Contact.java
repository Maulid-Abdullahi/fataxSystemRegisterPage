package Contact;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    @Column
    private String address;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String destination;


    public Contact() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}