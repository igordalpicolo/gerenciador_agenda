package br.com.gerenciadoragenda.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import br.com.gerenciadoragenda.entities.enums.Group;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contact")
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	private Integer group;
	
	private List<String> emails;
	private List<String> phones;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	private User schedule;
	
	public Contact() {
	}
	
	public Contact(Long id, String name, Group group) {
		super();
		this.id = id;
		this.name = name;
		setGroup(group);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getEmails() {
		return emails;
	}

	public List<String> getPhones() {
		return phones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Integer getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		if (group != null) {
			this.group = group.getCode();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(id, other.id);
	}

}
