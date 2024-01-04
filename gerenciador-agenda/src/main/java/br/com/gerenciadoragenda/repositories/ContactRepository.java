package br.com.gerenciadoragenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciadoragenda.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
