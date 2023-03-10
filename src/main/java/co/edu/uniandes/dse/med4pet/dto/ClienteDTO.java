package co.edu.uniandes.dse.med4pet.dto;

import lombok.Data;

@Data
public class ClienteDTO {
	
	//===========================================================================
	// Atributos
	//===========================================================================
	
	/**
	 * Identificador
	 */
	private Long id;
	
	/**
	 * Representa el nombre del cliente.
	 */
	private String nombre;
	
	/**
	 * Representa la calificacion dada al cliente.
	 */
	private Double calificacion;

	//===========================================================================
	// Asociaciones
	//===========================================================================
	
	private MedioDePagoDTO medioDePagoPredeterminado;
	
	private ContactoDTO contacto;

}
