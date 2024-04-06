package com.sachin.contactmanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sachin.contactmanagementsystem.dto.ContactDto;
import com.sachin.contactmanagementsystem.service.ContactService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @PostMapping
    public ResponseEntity<ContactDto> addContact(@RequestBody ContactDto contactDto)
    {
        return new ResponseEntity<>(contactService.createContact(contactDto),HttpStatus.CREATED);
    }
    @GetMapping("/all-contacts")
    public ResponseEntity<List<ContactDto>> getAllContacts()
    {
        List<ContactDto> contactDtoList=contactService.viewAllContacts();
        return ResponseEntity.ok(contactDtoList);
    }
    @GetMapping("/namesearch/{name}")
    public ResponseEntity<ContactDto> findContactByName(@PathVariable String name)
    {
        ContactDto findContactDto=contactService.searchByName(name);
        return  ResponseEntity.ok(findContactDto);
    }
    @GetMapping("/phonesearch/{phone}")
    public ResponseEntity<List<ContactDto>> findContactByPhone(@PathVariable Long phone)
    {
        List<ContactDto> contactDtoList=contactService.searchByPhone(phone);
        return  ResponseEntity.ok(contactDtoList);
    }
    @DeleteMapping("/{name}/delete")
    public ResponseEntity<String> deleteContact(@PathVariable String name)
    {
        contactService.deleteContact(name);
        return  ResponseEntity.ok("Contact Deleted Successfully");
    }
    @PutMapping("/editname/{name}")
    public ResponseEntity<ContactDto> editContactName(@PathVariable String name, @RequestBody Map <String,String> request)
    {
        String newname=request.get("newname");
        ContactDto contactDto=contactService.editContactName(name, newname);
        return ResponseEntity.ok(contactDto);
    }
    @PutMapping("/editnumber/{name}")
    public ResponseEntity<ContactDto> editContactNumber(@PathVariable String name, @RequestBody Map <String,Long> request)
    {
        Long newNumber=request.get("newnumber");
        ContactDto contactDto=contactService.editContactNumber(name, newNumber);
        return ResponseEntity.ok(contactDto);
    }
    
    
    

}
