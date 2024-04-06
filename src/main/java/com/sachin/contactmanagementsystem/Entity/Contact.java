package com.sachin.contactmanagementsystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@Entity
public class Contact {
    private Long phoneNumber;
    @Id
    private String name;
    @Email
    private String email;
    private String address;
    public Contact() {
    }
    public Contact(Long phoneNumber, String name, String email, String address) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.address = address;
    }
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Contact [phoneNumber=" + phoneNumber + ", name=" + name + ", email=" + email + ", address=" + address
                + "]";
    }
    

    

}
