package co.edu.uniandes.dse.med4pet.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PSEEntity extends MedioDePagoEntity
{
	private String banco;
	private String numeroTarjeta;
	
}
