package com.sachin.contactmanagementsystem.service;

import java.util.List;

import com.sachin.contactmanagementsystem.dto.ContactDto;

public interface ContactService {
    /*
     * Create Contact
     * Search by Phone Number
     * Edit Contact
     * Search by name
     * View all contacts 
     * Delete contact
     */
    ContactDto createContact(ContactDto contactDto);
    List<ContactDto> searchByPhone(Long phone);
    ContactDto searchByName(String name);
    ContactDto editContactName(String name,String newName);
    ContactDto editContactNumber(String name,Long phone);
    List <ContactDto> viewAllContacts();
    void deleteContact(String name);
}
