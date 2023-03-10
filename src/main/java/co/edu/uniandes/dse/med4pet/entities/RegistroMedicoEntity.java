package co.edu.uniandes.dse.med4pet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Setter
@Getter
public class RegistroMedicoEntity extends BaseEntity 
{
	//===========================================================================
	// Atributos
	//===========================================================================

	/**
	 * Representa la identificacion del registro medico del veterinario.
	 */
	private String identificacion;
	/**
	 * Representa la fecha de expedicion del registro medico.
	 */
	private Date fechaExpedicion;
	/**
	 * Representa la ruta de acceso de la imagen del registro medico.
	 */
	private String imagen;
	
	//===========================================================================
	// Asociaciones
	//===========================================================================

	/**
	 * Representa el veterinario que posee dicho registro medico.
	 */
	@PodamExclude
	@OneToOne
	private VeterinarioEntity veterinario;
	
	
}
