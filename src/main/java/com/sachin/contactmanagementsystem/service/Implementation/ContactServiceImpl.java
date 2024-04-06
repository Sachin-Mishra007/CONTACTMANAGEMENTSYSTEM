package com.sachin.contactmanagementsystem.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sachin.contactmanagementsystem.Entity.Contact;
import com.sachin.contactmanagementsystem.Repository.ContactRepository;
import com.sachin.contactmanagementsystem.dto.ContactDto;
import com.sachin.contactmanagementsystem.dto.ContactDtoMapper;
import com.sachin.contactmanagementsystem.service.ContactService;
@Service
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact=ContactDtoMapper.toContact(contactDto);
        Contact savecontact=contactRepository.save(contact);
        return ContactDtoMapper.toContactDto(savecontact);
    }

    @Override
    public List<ContactDto> searchByPhone(Long phone) {
        List<Contact> contactList=contactRepository.findByPhoneNumber(phone);
        List <ContactDto> contactDtoList=new ArrayList<>();
        for (Contact contact : contactList) {
            ContactDto contactDto= ContactDtoMapper.toContactDto(contact);
            contactDtoList.add(contactDto);
            
        }
        return contactDtoList;

    }

    @Override
    public ContactDto searchByName(String name) {
        Contact findContact=contactRepository.findById(name).orElseThrow(()->new RuntimeException("No concact found with name "+name));
        return ContactDtoMapper.toContactDto(findContact);
    }

    @Override
    public List<ContactDto> viewAllContacts() {
       List <ContactDto> contacDtoList=new ArrayList<>();
       List <Contact> contactList=contactRepository.findAll();
       for (Contact contact : contactList) {

        ContactDto contactDto=ContactDtoMapper.toContactDto(contact);
        contacDtoList.add(contactDto);
       }
       return contacDtoList;
    }

    @Override
    public void deleteContact(String name) {
        contactRepository.findById(name).orElseThrow(()->new RuntimeException("No contact found with name "+name));
        contactRepository.deleteById(name);
    }

    @Override
    public ContactDto editContactName(String name, String newName) {
        Contact findContact=contactRepository.findById(name).orElseThrow(()->new RuntimeException("No contact found with name "+name));
        contactRepository.deleteById(name);
        findContact.setName(newName);
        Contact saveContact=contactRepository.save(findContact);
        return ContactDtoMapper.toContactDto(saveContact);
    }

    @Override
    public ContactDto editContactNumber(String name, Long phone) {
        Contact findContact=contactRepository.findById(name).orElseThrow(()->new RuntimeException("No contact found with name "+name));
        findContact.setPhoneNumber(phone);
        Contact saveContact=contactRepository.save(findContact);
        return ContactDtoMapper.toContactDto(saveContact);
    }

}
