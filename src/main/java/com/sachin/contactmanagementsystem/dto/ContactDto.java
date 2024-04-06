package com.sachin.contactmanagementsystem.dto;

public class ContactDto {
    private Long phone;
    private String name;
    private String email;
    private String address;
    public ContactDto() {
    }
    public ContactDto(Long phone, String name, String email, String address) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.address = address;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
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
        return "ContactDto [phone=" + phone + ", name=" + name + ", email=" + email + ", address=" + address + "]";
    }
    
    
    
}
