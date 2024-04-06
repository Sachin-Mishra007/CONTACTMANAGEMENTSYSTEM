package com.sachin.contactmanagementsystem.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.contactmanagementsystem.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,String> {

    List<Contact> findByPhoneNumber(Long phoneNumber);
}
