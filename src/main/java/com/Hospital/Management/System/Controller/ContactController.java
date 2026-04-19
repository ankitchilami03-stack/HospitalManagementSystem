package com.Hospital.Management.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.Repository.ContactRepository;
import com.Hospital.Management.System.doclogin.entity.Contact;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")   // base path
public class ContactController 
{
	@Autowired
	ContactRepository contactRepository;
	@PostMapping("/contact")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact)
	{
		if(contact.getEmail() == null || contact.getEmail().isEmpty())
		{
		    throw new RuntimeException("Email is required");
		}
		 Contact saved = contactRepository.save(contact);
		    return ResponseEntity.ok(saved);
	}
}
