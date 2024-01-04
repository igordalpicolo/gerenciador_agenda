package br.com.gerenciadoragenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciadoragenda.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
