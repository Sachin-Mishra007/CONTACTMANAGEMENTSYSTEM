package com.sachin.contactmanagementsystem.dto;

import com.sachin.contactmanagementsystem.Entity.Contact;

public class ContactDtoMapper {
    public static ContactDto toContactDto(Contact contact)
    {
        ContactDto contactDto=new ContactDto(contact.getPhoneNumber(),contact.getName(),contact.getEmail(),contact.getAddress());
        return contactDto;
    }
    public static Contact toContact(ContactDto contactDto)
    {
        return new Contact(contactDto.getPhone(),contactDto.getName(),contactDto.getEmail(),contactDto.getAddress());
    }

}
