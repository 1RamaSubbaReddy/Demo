package com.jsp.ContactBookApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ContactBookApp.Dto.Contact;
import com.jsp.ContactBookApp.Repository.ContactRepository;

@Service
public class ContactService {


	ContactRepository repository;

	@Autowired
	public ContactService(ContactRepository repository) {
		this.repository = repository;
	}

	// to save contact to DB
	public Contact saveContact(Contact con) {
		return repository.save(con);
	}

	// to find contact by ID
	public Contact getContactById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	// to get all contacts from DB
	public List<Contact> getAllContacts()
	{
		return repository.findAll();
	}
	
	// to delete Contact By Id
	public void deleteByID(int id)
	{
		repository.deleteById(id);
	}
}
