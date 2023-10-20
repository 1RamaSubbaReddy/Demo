package com.jsp.ContactBookApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ContactBookApp.Dto.Contact;
import com.jsp.ContactBookApp.Service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {


	@Autowired
	ContactService service;
	
	@PostMapping
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact)
	{
		Contact con = service.saveContact(contact);
		return ResponseEntity.ok(con);
	}
	
	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts()
	{
		List<Contact> lt = service.getAllContacts();
		return ResponseEntity.ok(lt);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Contact> getContactById(@RequestParam int id)
	{
		Contact con = service.getContactById(id);
		if(con != null)
			return ResponseEntity.ok(con);
		else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteContact(@RequestParam int id)
	{
		Contact con = service.getContactById(id);
		if(con != null)
		{
			service.deleteByID(id);
			return ResponseEntity.noContent().build();
		}
		else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping
	public ResponseEntity<Contact> updateContact(@RequestParam int id,@RequestParam String newname)
	{
		Contact con = service.getContactById(id);
		if(con != null)
		{
			con.setName(newname);
			Contact newContact = service.saveContact(con);
			return ResponseEntity.ok(newContact);
		}
		else
			return ResponseEntity.notFound().build();
	}
}
