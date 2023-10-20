package com.jsp.ContactBookApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ContactBookApp.Dto.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
