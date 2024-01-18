package br.com.gerenciadoragenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciadoragenda.entities.Contact;
import br.com.gerenciadoragenda.services.ContactService;

@RestController
@RequestMapping(value = "/contacts")
public class ContactResource {

	@Autowired
	private ContactService service;

	@GetMapping
	public ResponseEntity<List<Contact>> findAll() {
		List<Contact> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Contact> findById(@PathVariable Long id) {
		Contact obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
