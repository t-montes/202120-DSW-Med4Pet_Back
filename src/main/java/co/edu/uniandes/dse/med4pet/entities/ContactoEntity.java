package co.edu.uniandes.dse.med4pet.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContactoEntity extends BaseEntity{
	private String telefono;
	private String correo;
	
}
