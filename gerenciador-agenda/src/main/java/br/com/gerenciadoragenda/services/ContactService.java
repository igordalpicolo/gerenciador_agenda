package br.com.gerenciadoragenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.gerenciadoragenda.entities.Contact;
import br.com.gerenciadoragenda.entities.enums.Team;
import br.com.gerenciadoragenda.repositories.ContactRepository;
import br.com.gerenciadoragenda.services.execeptions.DatabaseException;
import br.com.gerenciadoragenda.services.execeptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;
	
	public List<Contact> findAll(){
		return repository.findAll();
	}
	
	public Contact findById(Long id) {
		Optional<Contact> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Contact insert(Contact obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Contact update(Long id, Contact obj) {
		try {
			Contact entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Contact entity, Contact obj) {
		entity.setName(obj.getName());
		entity.setPhone(obj.getPhone());
		entity.setEmail(obj.getEmail());
		entity.setTeam(Team.valueOf(obj.getTeam()));
	}
	
}
