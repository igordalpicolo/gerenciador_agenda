package br.com.gerenciadoragenda.entities.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.gerenciadoragenda.entities.Contact;
import br.com.gerenciadoragenda.entities.User;
import br.com.gerenciadoragenda.entities.enums.Team;
import br.com.gerenciadoragenda.repositories.ContactRepository;
import br.com.gerenciadoragenda.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Bob green", 12345);
		User u2 = new User(null, "Maria red",6789);
		
		Contact c1 = new Contact(null, "Nataly", "nataly@email.com", "11112222", null);
		
		u1.getContacts().add(new Contact(null, "Jason", "jason@email.com", "12345678", Team.FAMILY));
		u1.getContacts().add(new Contact(null, "Maria", "maria@email.com", "13265487", Team.FRIENDS));
		u1.getContacts().add(new Contact(null, "Amil", "amil@email.com", "78321447", Team.JOB));
		
		u2.getContacts().add(new Contact(null, "Alec", "alec@email.com", "88887777", Team.FAMILY));
		u2.getContacts().add(new Contact(null, "Cliford", "cliford@email.com", "99991111", Team.JOB));
		u2.getContacts().add(new Contact(null, "Rose", "rose@email.com", "11116666", Team.FRIENDS));
		
		u1.getContacts().add(c1);
		u2.getContacts().add(c1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		contactRepository.save(c1);
		
	}
	
}
